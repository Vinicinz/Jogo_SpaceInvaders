
import java.awt.*;
import javax.swing.*;

public class GameOverScreen extends JPanel {

    private Timer timer1;
    private Timer timer2;
    private TelaInicial telaInicial;
    private EfeitosSonoros musica;

    public GameOverScreen(TelaInicial telaInicial) {
        this.telaInicial = telaInicial;

        setLayout(new BorderLayout());

        musica = new EfeitosSonoros();
        MusicaOver();


        // Inicia o timer para voltar na tela inicial após 10 segundos
        timer1 = new Timer(9000, e -> returnToInitialScreen());
        timer2 = new Timer(9000, e -> PararMusica());

        timer1.setRepeats(false); // sem isso o timer fica resetando e mandando pra tela inicial toda vez
        timer1.start();
        timer2.setRepeats(false); // sem isso o timer fica resetando e mandando pra tela inicial toda vez
        timer2.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graficos = (Graphics2D) g;

        // Carrega e desenha a imagem de fim de jogo
        ImageIcon fimJogo = new ImageIcon("res\\Painel\\fimdejogo.png");
        Image image = fimJogo.getImage();
        graficos.drawImage(image, 0, 0, this);
    }

    public void MusicaOver(){
        musica.MusicaOver();

    }
    public void PararMusica(){
        musica.Parar();
    }

    private void returnToInitialScreen() {
        telaInicial.showInitialScreen();
    }
}