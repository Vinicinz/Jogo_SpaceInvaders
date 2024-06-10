
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class EnemyTiro {

    private Image image;
    private int x, y;
    private int altura, largura;
    private boolean isVisivel;
    private int VELOCIDADE = -6;
    private static final int LARGURA = 1024;

    public EnemyTiro(int x, int y){
        this.x = x;
        this.y = y;

        isVisivel = true;
        
    }


    public void load(){
        ImageIcon referencia = new ImageIcon("res\\Tiros\\TiroInimigo3.gif");
        image = referencia.getImage();

        this.altura = image.getHeight(null);
        this.largura = image.getWidth(null);


    }

    public void update(){
        this.x += VELOCIDADE;
        if (this.x > LARGURA) {
			isVisivel = false;
		}

		if (this.x < 0) {
			isVisivel = false;
		}
    }


    public Rectangle getBounds(){
        return new Rectangle(x,y,largura,altura);
    }


    public Image getImage() {
        return image;
    }


    public void setImage(Image image) {
        this.image = image;
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


    public int getAltura() {
        return altura;
    }


    public void setAltura(int altura) {
        this.altura = altura;
    }


    public int getLargura() {
        return largura;
    }


    public void setLargura(int largura) {
        this.largura = largura;
    }


    public boolean isVisivel() {
        return isVisivel;
    }


    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public void setVELOCIDADE(int vELOCIDADE) {
        VELOCIDADE = vELOCIDADE;
    }


}
