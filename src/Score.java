import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Score implements Runnable {

    private boolean jogo;
    private int i = 0;
    private String path = "score.txt";

    public Score(boolean jogo) {
        this.jogo = jogo;
    }

    @Override
    public void run() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            while (jogo) {
                i += 1;
                Thread.sleep(1000);
                System.out.println(i);
            }
            System.out.println("Sua pontuação total foi de " + i);
            bw.write("Sua pontuação foi de " + i);
            bw.newLine();

        } catch (InterruptedException e) {
            System.err.println("A thread foi interrompida: " + e.getMessage());

        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
        }

    }

    public boolean isEmJogo() {
        return jogo;
    }

    public void setEmJogo(boolean jogo) {
        this.jogo = jogo;
    }

}
