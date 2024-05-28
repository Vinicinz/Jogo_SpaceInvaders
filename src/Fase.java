
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {

    private Image fundo1;
    private Image fundo2;
    private Image fundo3;
    private Player player;
    private Timer timer;
    private Clip clip;
    private List <Enemy1> enemy1; 

    // Construtor Fase
    public Fase() {

        requestFocus();
        setFocusable(true);
        setDoubleBuffered(true);

        //Imagem de fundo preta
        ImageIcon referencia1 = new ImageIcon("res\\Background.jpg");
        fundo1 = referencia1.getImage();

        //Upando a musica de batalha e definindo o valor fixo de volume
        try {
            File file = new File("res\\xDeviruchi - Prepare for Battle! .wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            FloatControl voluControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            voluControl.setValue(-20.0f);

        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        }

        //criando o player, iniciando o inimigo na fase e o timer pra fazer da update na fase
        player = new Player();
        player.load();

        inicializaInimigo();

        addKeyListener(new TecladoAdapter());

        timer = new Timer(5, this);
        timer.start();
    }

    // metodo que define previamente a posição de todos os inimigos no inicio da fase, ela cria uma lista de 40 inimigos e posiciona eles fora da fase
    public void inicializaInimigo(){
        int cordenadas[] = new int [40];
        enemy1 = new ArrayList<Enemy1>();

        for (int i = 0; i < cordenadas.length; i++) {
            int x = (int)(Math.random()* 8000 + 1024);
            int y = (int)(Math.random()* 650 + 30);
            enemy1.add(new Enemy1(x, y));            
        }
    }

    // Paint component é importante pra mostrar oq ta rolando e acontecendo na fase
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graficos = (Graphics2D) g;
        // definindo um fundo estatico
        graficos.drawImage(fundo1, 0, 0, null);
        // definindo que o player recebe posições de acordo com as mudanças na classe player
        graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

        // laço para atualiza a movimentação do inimigo
        for (int j = 0; j < enemy1.size(); j++) {
            Enemy1 in = enemy1.get(j);
            in.load();
            graficos.drawImage(in.getImagem(), in.getX() , in.getY(), this);
        }

        //laço para atualizar a movimentação do tiro
        List<Tiro> tiros = player.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            Tiro m = tiros.get(i);
            m.load();
            graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
        }
        g.dispose();
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

        repaint();
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
