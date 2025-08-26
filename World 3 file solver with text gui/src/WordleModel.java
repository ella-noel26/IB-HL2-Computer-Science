import java.io.IOException;

public interface WordleModel {
    public int setInitialWords(String file) throws IOException;
    public String getGuess();
    public void update(int[] results);
}
