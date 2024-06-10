
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

// classe Player 
public class Player {

    private int x, y;
    private int dx, dy;
    private Image imagem;
    private int altura, largura;
    private List <Tiro> tiros;
    private boolean isVisivel;
    private EfeitosSonoros som;


    // contrutor player e declaração que ele pode criar uma lista com a classe tiros
    public Player() {
        this.x = 100;
        this.y = 100;
        isVisivel = true;
        tiros = new ArrayList<Tiro>();
        som = new EfeitosSonoros();
    }

    // carregando minha imagem do jogador
    public void load() {
        ImageIcon referencia = new ImageIcon("res\\Player\\spaceship2.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
    }

    // chamo este update na fase pra definir a movimentação do jogador
    public void update() {
        x += dx;
        y += dy;

        if (x < 6){
            x = 6; 
        }
        if (x > 938) {
			x = 938;
		}

		if (y < 6) {
			y = 6;
		}
		if (y > 694) {
			y = 694;
		}
    }

    // Criando metodo tiro simples pra ser chamado no teclado e criar um Tiro na Fase que começa do jogador
    public void tiroSimples(){
        this.tiros.add(new Tiro(x+largura, y + (altura /2) - 10));

    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,largura,altura);
    }
    public void MusicaTiro(){
        som.MusicaTiro();
    }

    // Metodo para ler as entradas do teclado no programa
    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_A) {
            tiroSimples();
            MusicaTiro();
        }
        
        if (codigo == KeyEvent.VK_UP) {
            dy = -3;
        }
        if (codigo == KeyEvent.VK_DOWN) {
            dy = 3;
        }
        if (codigo == KeyEvent.VK_LEFT) {
            dx = -3;
        }
        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 3;
        }
    }

    // metodo pra atualizar e parar de andar com a nave no programa
    public void keyReleased(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (codigo == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        if (codigo == KeyEvent.VK_LEFT) {
            dx = 0;
        }
        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }

    // Getters e Setters da classe Player
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Tiro> getTiros() {
        return tiros;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
    
}
