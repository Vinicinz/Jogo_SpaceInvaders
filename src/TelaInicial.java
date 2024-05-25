
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class TelaInicial extends JPanel implements ActionListener{

    // metodo principal TelaInical qu eé chamado no Container 
    public TelaInicial() {

        setLayout(null);

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
                Fase fase = new Fase();
                Container container = (Container) SwingUtilities.getWindowAncestor(TelaInicial.this);
                container.setContentPane(fase);
                container.revalidate();
                fase.requestFocus();
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

        JButton startButton = (JButton) getComponent(0);
        int x = (getWidth() - startButton.getWidth()) / 2;
        int y = (getHeight() / 2) - startButton.getHeight();
        startButton.setLocation(x, y);

        JButton exitButton = (JButton) getComponent(1);
        int yExit = (getHeight() / 2) + 10;
        exitButton.setLocation(x, yExit);

    }

    // Metodo gerado autiomaticamente, n me pergunte oq ele faz kkkk
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
