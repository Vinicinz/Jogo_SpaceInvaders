
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

// Classe Tiro que eu chamo no player toda vez que um botão é apertado e cria uma lista com essa classe na fase
public class Tiro {

    private Image imagem;
    private int x, y;
    private int largura,altura;
    private boolean isVisivel;
    private static final int LARGURA = 938;
    private static int VELOCIDADE = 5;


    // Construtor Tiro que recebe as cordenadas
    public Tiro(int x, int y) {
        this.x = x;
        this.y = y;
        isVisivel = true;
    }

    //Carregando a imagem do Tiro
    public void load(){
    ImageIcon referencia = new ImageIcon("res\\Tiros\\TiroSimples.gif");
    imagem = referencia.getImage();

    this.largura = imagem.getWidth(null);
    this.altura = imagem.getHeight(null);
    }

    // Toda vez que é atualizado o tiro recebe a velociadade 
    public void update(){
        this.x += VELOCIDADE;
        if (this.x > LARGURA){
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
