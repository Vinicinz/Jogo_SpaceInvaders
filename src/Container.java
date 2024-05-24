
import javax.swing.JFrame;

public class Container extends JFrame {

    public Container() {
        add(new TelaInicial());
        setTitle("Meu Jogo");
        setSize(1024, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Container();
    }

}
