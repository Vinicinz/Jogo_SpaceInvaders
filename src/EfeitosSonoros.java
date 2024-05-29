
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EfeitosSonoros extends JPanel {

    private Clip clip;

    public EfeitosSonoros() {
        setDoubleBuffered(true);
    }

    public void Parar() {
        clip.stop();
    }

    public void MusicaTela() {

        try {
            File file = new File("res\\Musicas\\TitleTheme .wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            FloatControl voluControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            voluControl.setValue(-20.0f);

        } catch (Exception e) {
            JOptionPane.showInputDialog(this, e);
        }
    }

    public void MusicaFase() {

        try {
            File file = new File("res\\Musicas\\PrepareForBattle.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            FloatControl voluControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            voluControl.setValue(-20.0f);

        } catch (Exception e) {
            JOptionPane.showInputDialog(this, e);
        }
    }

    public void MusicaOver() {

        try {
            File file = new File("res\\Musicas\\GameOver.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            FloatControl voluControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            voluControl.setValue(-20.0f);
        } catch (Exception e) {
            JOptionPane.showInputDialog(this, e);

        }
    }

    public void MusicaTiro(){
        try {
            File file = new File("res\\Musicas\\SomTiro.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            FloatControl voluControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            voluControl.setValue(-20.0f);
        } catch (Exception e) {
            JOptionPane.showInputDialog(this, e);

        } 
    }

    public void MusicaExplosao(){
        try {
            File file = new File("res\\Musicas\\SomExplosao.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

            FloatControl voluControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            voluControl.setValue(-10.0f);
        } catch (Exception e) {
            JOptionPane.showInputDialog(this, e);

        } 
    }
    

}
