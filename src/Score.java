import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Score implements Runnable{

    private boolean jogo;
    public int pontuacao = 1;
    private String path = "res\\score.txt";

    public Score(boolean jogo) {
        this.jogo = jogo;
    }

    @Override
    public void run() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            while (jogo) {
                this.pontuacao += 1;
                System.out.println(pontuacao);
                Thread.sleep(500);
            }
            System.out.println("Sua pontuação total foi de " + pontuacao);
            bw.write("Sua pontuação foi de " + pontuacao);
            bw.newLine();

        } catch (InterruptedException e) {
            System.err.println("A thread foi interrompida: " + e.getMessage());

        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
        }

    }

    public void SomaPonto(){
        pontuacao += 5;
    }

    public boolean isEmJogo() {
        return jogo;
    }

    public void setEmJogo(boolean jogo) {
        this.jogo = jogo;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    
}
