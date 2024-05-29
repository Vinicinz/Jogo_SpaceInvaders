
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {

    private Image fundo1;
    private Player player;
    private Timer timer;
    private Clip clip;
    private List<Enemy1> enemy1;
    private boolean emJogo;
    private TelaInicial telaInicial;
    private EfeitosSonoros musica;


    // Construtor Fase
    public Fase(TelaInicial telaInicial) {
        this.telaInicial = telaInicial;
        
        requestFocus();
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());

        //Imagem de fundo preta
        ImageIcon referencia1 = new ImageIcon("res\\Painel\\Background.jpg");
        fundo1 = referencia1.getImage();

        //Upando a musica de batalha
        musica = new EfeitosSonoros();
        MusicaFase();

        //criando o player
        player = new Player();
        player.load();

        //iniciando o inimigo na fase e o timer pra fazer da update na fase
        inicializaInimigo();
        emJogo = true;
        timer = new Timer(5, this);
        timer.start();
    }

    // metodo que define previamente a posição de todos os inimigos no inicio da fase, ela cria uma lista de 40 inimigos e posiciona eles fora da fase
    public void inicializaInimigo() {
        int cordenadas[] = new int[40];
        enemy1 = new ArrayList<Enemy1>();

        for (int i = 0; i < cordenadas.length; i++) {
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            enemy1.add(new Enemy1(x, y));
        }
    }

    // Paint component para colocar os objetos na fase
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graficos = (Graphics2D) g;
        if (emJogo == true) {
            // definindo um fundo estatico
            graficos.drawImage(fundo1, 0, 0, null);

            // definindo que o player recebe posições de acordo com as mudanças na classe player
            graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

            // laço para atualiza a movimentação do inimigo
            for (int j = 0; j < enemy1.size(); j++) {
                Enemy1 in = enemy1.get(j);
                in.load();
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
            }

            //laço para atualizar a movimentação do tiro
            List<Tiro> tiros = player.getTiros();
            for (int i = 0; i < tiros.size(); i++) {
                Tiro m = tiros.get(i);
                m.load();
                graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
            }
        }
    }

    // O Action permormed que atualiza oq esta acontecendo na fase
    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();

        List<Tiro> tiros = player.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            Tiro m = tiros.get(i);
            if (m.isVisivel()) {
                m.update();
            } else {
                tiros.remove(i);
            }
        }

        for (int o = 0; o < enemy1.size(); o++) {
            Enemy1 in = enemy1.get(o);
            if (in.isVisivel()) {
                in.update();
            } else {
                enemy1.remove(o);
            }
        }

        checarColisoes();
        repaint();
    }

    // checando se há colisões entre os retangulos criados em volta da nossa imagem
    public void checarColisoes() {
        Rectangle formaNave = player.getBounds();
        Rectangle formaEnemy1;
        Rectangle formaTiro;

        for (int i = 0; i < enemy1.size(); i++) {
            Enemy1 tempEnemy1 = enemy1.get(i);
            formaEnemy1 = tempEnemy1.getBounds();

            if (formaNave.intersects(formaEnemy1)) {
                player.setVisivel(false);
                tempEnemy1.setVisivel(false);
                emJogo = false;
                showGameOverScreen();
            }
        }

        List<Tiro> tiros = player.getTiros();
        for (int j = 0; j < tiros.size(); j++) {
            Tiro tempTiro = tiros.get(j);
            formaTiro = tempTiro.getBounds();

            for (int o = 0 ; o < enemy1.size(); o++) {
                Enemy1 tempEnemy1 = enemy1.get(o);
                formaEnemy1 = tempEnemy1.getBounds();

                if (formaTiro.intersects(formaEnemy1)){
                    tempEnemy1.setVisivel(false);
                    tempTiro.setVisivel(false);

                }

            }

        }
    }
    private void showGameOverScreen() {
        timer.stop();
        PararMusica();
        telaInicial.showGameOverScreen();
    }

    public void MusicaFase() {
		musica.MusicaFase();
	}
    public void PararMusica(){
        musica.Parar();
    }

    // Declarando o Teclado adapter pra minha fase entender quando eu precionar as teclas
    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);

        }
    }

    // getters e setters
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public List<Enemy1> getEnemy1() {
        return enemy1;
    }

    public void setEnemy1(List<Enemy1> enemy1) {
        this.enemy1 = enemy1;
    }

}
