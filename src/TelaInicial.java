
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class TelaInicial extends JPanel implements ActionListener{

    public TelaInicial() {

        setLayout(null);

        JButton startButton = new JButton("Start");

        startButton.setForeground(Color.BLACK);
        startButton.setBackground(Color.decode("#ffffff"));
        startButton.setFont(new Font("Infinix Display", Font.PLAIN, 35));
        startButton.setSize(200, 50);
        startButton.setFocusPainted(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fase fase = new Fase();
                Container container = (Container) SwingUtilities.getWindowAncestor(TelaInicial.this);
                container.setContentPane(fase);
                container.revalidate();
                fase.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
                fase.requestFocus();
            }
        });

        JButton exitButton = new JButton("Sair");

        exitButton.setForeground(Color.BLACK);
        exitButton.setBackground(Color.decode("#ffffff"));
        exitButton.setFont(new Font("Infinix Display", Font.PLAIN, 35));
        exitButton.setSize(200, 50);

        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        add(startButton);
        add(exitButton);

    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
