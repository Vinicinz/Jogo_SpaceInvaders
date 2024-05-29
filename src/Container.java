
import javax.swing.JFrame;

public class Container extends JFrame {

    public Container() {
        setTitle("Meu Jogo");
        setSize(1024, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);

        TelaInicial telaInicial = new TelaInicial(this);
        setContentPane(telaInicial);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Container();
    }

}
