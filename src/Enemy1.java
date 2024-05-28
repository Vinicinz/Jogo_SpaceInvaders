
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

// Classe Inimigo que eu chamo na fase
public class Enemy1 {

    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisivel;
    private static final int LARGURA = 0;
    private static int VELOCIDADE = -2;


    // Construtor do inimigo1 que recebe as cordenadas
    public Enemy1 (int x, int y) {
        this.x = x;
        this.y = y;
        isVisivel = true;
    }

    //Carregando a imagem do inimigo
    public void load(){
    ImageIcon referencia = new ImageIcon("res\\Inimigo\\enemy1.png");
    imagem = referencia.getImage();

    this.largura = imagem.getWidth(null);
    this.altura = imagem.getHeight(null);
    }

    // Toda vez que é atualizado o inimigo recebe a velociadade negativa e retrocede na fase
    public void update(){
        this.x += VELOCIDADE;
        if (this.x < LARGURA){
            isVisivel = false;
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,largura,altura);
    }

    // getters e Setters da classe 
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int vELOCIDADE) {
        VELOCIDADE = vELOCIDADE;
    }

    public Image getImagem() {
        return imagem;
    }

}
