
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class TelaInicial extends JPanel implements ActionListener{

        private Clip clip;
        private Image imagem1; 
        private Container container;


    // metodo principal TelaInical qu eé chamado no Container 
    public TelaInicial(Container container) {
        this.container = container;

        setLayout(null);
        ImageIcon referencia = new ImageIcon("res\\Painel\\FundoInicial.gif");
        imagem1 = referencia.getImage();

        //Upando a musica de batalha e definindo o valor fixo de volume
        try {
            File file = new File("res\\Musicas\\TitleTheme .wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            FloatControl voluControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            voluControl.setValue(-20.0f);

        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
        }

        // Criação do Botão Start e Estilização
        JButton startButton = new JButton("Start");

        startButton.setForeground(Color.BLACK);
        startButton.setBackground(Color.decode("#ffffff"));
        startButton.setFont(new Font("Infinix Display", Font.PLAIN, 35));
        startButton.setSize(200, 50);
        startButton.setFocusPainted(false);

        // Adicionando a ação deste Botao, que vai chamar a classe Fase() 
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.stop();
                startGame();
            }
        });
        // Criação do Botão Sair e Estilização

        JButton exitButton = new JButton("Sair");
        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(Color.decode("#ffffff"));
        exitButton.setFont(new Font("Infinix Display", Font.PLAIN, 35));
        exitButton.setSize(200, 50);

        // Adicionando a ação pra fechar o app
        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        //pra adicionar os botões 
        add(startButton);
        add(exitButton);

    }

    // Metodo para centralizar os botões no meio da
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
    public void showInitialScreen() {
        clip.setFramePosition(0); // Reseta a música para o início
        container.getContentPane().removeAll(); // Remove todos os componentes do contêiner
        container.add(new TelaInicial(container)); // Adiciona uma nova instância de TelaInicial
        container.revalidate(); // Atualiza o layout do contêiner
    }
       
    public void showGameOverScreen() {
        GameOverScreen gameOver = new GameOverScreen(this); // Passa uma referência para TelaInicial
        container.setContentPane(gameOver);
        container.revalidate();
        gameOver.requestFocus();
    }

    // Metodo gerado autiomaticamente, n me pergunte oq ele faz kkkk
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
