
import java.awt.*;
import javax.swing.*;

public class GameOverScreen extends JPanel {

    private Timer timer1;
    private Timer timer2;
    private TelaInicial telaInicial;
    private EfeitosSonoros musica;
    private int score;

    public GameOverScreen(TelaInicial telaInicial, int score) {
        this.telaInicial = telaInicial;
        this.score = score;
        this.setBackground(Color.black);


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
        // Carrega e desenha a imagem de fim de jogo
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (getWidth() - metrics1.stringWidth("Game Over")) / 2, getHeight() / 2);

        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        g.drawString("Total Score: " + score, (getWidth()/2) - 110, ((getHeight()/2) + 90));
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