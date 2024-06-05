
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy3 {

    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisivel;
    private int LARGURA = 0;
    private int VELOCIDADE = -1;

    public Enemy3(int x, int y) {
        this.x = x;
        this.y = y;
        isVisivel = true;
    }

    public void load(){
        ImageIcon referencia = new ImageIcon("res\\Inimigo\\enemy3.png");
        imagem = referencia.getImage();

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }

    public void update(){
        this.x += VELOCIDADE;
        if (this.x < LARGURA){
            isVisivel = false;
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,largura,altura);
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

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public int getLARGURA() {
        return LARGURA;
    }

    public void setLARGURA(int LARGURA) {
        this.LARGURA = LARGURA;
    }

    public int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public void setVELOCIDADE(int VELOCIDADE) {
        this.VELOCIDADE = VELOCIDADE;
    }
    

    



}
