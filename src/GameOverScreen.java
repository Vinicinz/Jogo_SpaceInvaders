
import java.awt.*;
import javax.swing.*;

public class GameOverScreen extends JPanel {

    private Timer timer;
    private TelaInicial telaInicial;

    public GameOverScreen(TelaInicial telaInicial) {
        this.telaInicial = telaInicial;

        setLayout(new BorderLayout());

        // Inicia o timer para voltar à tela inicial após 5 segundos
        timer = new Timer(5000, e -> returnToInitialScreen());
        timer.setRepeats(false); // Executa apenas uma vez
        timer.start();
    
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

    private void returnToInitialScreen() {
        telaInicial.showInitialScreen();
    }
}