
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Enemy4 {

    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisivel;
    private int LARGURA = 0;
    private int VELOCIDADE = -4;
    private int vida;
    private List<Explosao> explosoes;

    public Enemy4(int x, int y) {
        this.x = x;
        this.y = y;
        this.isVisivel = true;
        vida = 1;
        explosoes = new ArrayList<Explosao>();

    }

    public void explosoes() {
        this.explosoes.add(new Explosao(x + largura, y + altura / 2));

    }

    public void load() {

        if (vida == 1) {
            ImageIcon referencia = new ImageIcon("res\\Inimigo\\enemy4.png");
            imagem = referencia.getImage();

        }

        if (vida == 2) {
            ImageIcon referencia = new ImageIcon("res\\Inimigo\\enemy4Hitmed.png");
            imagem = referencia.getImage();
        }

        if (vida == 3) {
            ImageIcon referencia = new ImageIcon("res\\Inimigo\\enemy4Hit.png");
            imagem = referencia.getImage();
        }

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }

    public void update() {
        this.x += VELOCIDADE;
        if (this.x < LARGURA) {
            isVisivel = false;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, largura, altura);
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
