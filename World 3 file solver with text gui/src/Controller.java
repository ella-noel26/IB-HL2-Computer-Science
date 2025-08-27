import java.util.ArrayList;

public class Controller implements WordleController{
    
    Model model;
    int[][] wordsGrid;
    int currentLine;

    public Controller(){
        this.model = new Model();
        this.wordsGrid = new int[6][5];
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 5; j++){
                wordsGrid[i][j] = -1;
            }
        }
        this.currentLine = 0;
    }
    
    public void setColor(int col, int color){
        wordsGrid[currentLine][col] = color;
    }
    public void submit(){
        model.update(wordsGrid[currentLine]);
        currentLine += 1;
    }
    public char[] reportGuess(){
        String str = model.getGuess();
        char[] arr = new char[5];
        for (int i = 0; i < 5; i++){
            arr[i] = str.charAt(i);
        }
        return arr;
    }
}
