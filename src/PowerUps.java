import java.awt.Image;
public class PowerUps {

    private Image vida;
    private int x, y;
    private int largura, altura;
    private boolean isVisivel;

    public PowerUps(int x, int y) {
        this.x = x;
        this.y = y;
        this.isVisivel = isVisivel;

    }

    public void load_Vida() {
        this.altura = vida.getHeight(null);
        this.largura = vida.getWidth(null);
    }

    public Image getVida() {
        return vida;
    }

    public void setVida(Image vida) {
        this.vida = vida;
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

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

}
