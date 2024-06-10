
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Estrela {

    private Image imagem; 
    private int x, y;
    private int altura, largura;
    private static final int LARGURA = 1024;
    private static int VELOCIDADE = 2;
    private boolean isVisible;

    public Estrela(int x, int y) {
        this.x = x;
        this.y = y;
        isVisible = true;
    }

    public void load(){
        ImageIcon referencia = new ImageIcon("res\\Efeitos\\Star1.png");
        imagem = referencia.getImage();

        this.largura = imagem.getWidth(null);
        this.altura=imagem.getHeight(null);
    }

    public void update(){
		if (this.x < 0) {
			this.x = LARGURA;
			Random a = new Random();
			int m = a.nextInt(500);
			this.x = m + 1024;
			Random r = new Random();
			int n = r.nextInt(768);
			this.y = n;
		} else {
			this.x -= VELOCIDADE;
		}
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int VELOCIDADE) {
        Estrela.VELOCIDADE = VELOCIDADE;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }


}
