
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class TelaInicial extends JPanel implements ActionListener{

        private Clip clip;
        private Image imagem1; 
        private Container container;
        private EfeitosSonoros musica;

    // metodo principal TelaInical que é chamado no Container 
    public TelaInicial(Container container) {
        this.container = container;

        setLayout(null);
        ImageIcon referencia = new ImageIcon("res\\Painel\\FundoInicial.gif");
        imagem1 = referencia.getImage();

        //Upando a musica da tela inicial
        musica = new EfeitosSonoros();
        MusicaTela();

        // Criação do Botão Start e Estilização
        JButton startButton = new JButton("START");

        startButton.setForeground(Color.decode("#803D3B"));
        startButton.setBackground(Color.decode("#E4C59E"));
        startButton.setFont(new Font("alagard", Font.PLAIN, 35));
        startButton.setSize(200, 50);
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2)); // Borda azul escura com largura 2
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor em forma de mão


        // Adicionando a ação deste Botao, que vai chamar a classe Fase() e para a musica
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PararMusica();
                startGame();
            }
        });
        // Criação do Botão Sair e Estilização

        JButton exitButton = new JButton("SAIR");
        exitButton.setForeground(Color.decode("#803D3B"));
        exitButton.setBackground(Color.decode("#E4C59E"));
        exitButton.setFont(new Font("alagard", Font.PLAIN, 35));
        exitButton.setSize(200, 50);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 2)); // Borda azul escura com largura 2
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor em forma de mão


        // Adicionando a ação pra fechar o app
        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        //pra adicionar os botões 
        add(startButton);
        add(exitButton);

    }

    // Metodo para centralizar os botões no meio da tela
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(imagem1, 0, 0, this);

        

        JButton startButton = (JButton) getComponent(0);
        int x = (getWidth() - startButton.getWidth()) / 2;
        int y = (getHeight() / 2) - startButton.getHeight();
        startButton.setLocation(x, y);

        JButton exitButton = (JButton) getComponent(1);
        int yExit = (getHeight() / 2) + 10;
        exitButton.setLocation(x, yExit);

    }

    // Método para iniciar o jogo (startGame)
    private void startGame() {
        Fase fase = new Fase(this);
        container.setContentPane(fase);
        container.revalidate();
        fase.requestFocus();
    }

    // Metodo para ser chamado no gameover e começa novamente o jogo
    public void showInitialScreen() {
        container.getContentPane().removeAll(); 
        container.add(new TelaInicial(container));
        container.revalidate();
    }

    // Metodo que vou chmar quando morrer 
    public void showGameOverScreen() {
        GameOverScreen gameOver = new GameOverScreen(this); // Passa uma referência para TelaInicial
        container.setContentPane(gameOver);
        container.revalidate();
        gameOver.requestFocus();
    }

    // Musicas na tela inicial
    public void MusicaTela() {
		musica.MusicaTela();
	}
    public void PararMusica(){
        musica.Parar();
    }

    // Metodo gerado autiomaticamente
    public void actionPerformed(ActionEvent e) {
    }

}
