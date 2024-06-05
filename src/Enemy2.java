
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy2 {

    private Image imagem;
    private int x, y;
    private int largura, altura;
    private int LARGURA = 0;
    private int VELOCIDADE = -3;
    private boolean isVisivel;


    public Enemy2(int x, int y) {
        this.x = x;
        this.y = y;
        this.isVisivel = true;
    }

    public void load(){

        ImageIcon referencia = new ImageIcon("res\\Inimigo\\enemy2.png");
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

    public int getY() {
        return y;
    }

    public int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVELOCIDADE(int VELOCIDADE) {
        this.VELOCIDADE = VELOCIDADE;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    

}
