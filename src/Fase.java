
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
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

        //criando o player e o timer pra fazer rodar
        player = new Player();
        player.load();

        addKeyListener(new TecladoAdapter());

        timer = new Timer(5, this);
        timer.start();
    }

    // Paint component é importante pra mostrar oq ta rolando e acontecendo na fase
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo1, 0, 0, null);
        graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);

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

}
