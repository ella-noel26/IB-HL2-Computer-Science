import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Model implements WordleModel{
    
    private ArrayList<ArrayList<Character>> possibleAnswers;

    public Model(){
        this.possibleAnswers = new ArrayList<>(2500);
        try {
            setInitialWords("lib\\words.txt");
        } 
        catch (IOException e){
            System.out.println("Didn't work....");
        }
        
        for (int i = 0; i < possibleAnswers.size(); i++){
            ArrayList<Character> arr = possibleAnswers.get(i);
            for (int j = 0; j < arr.size(); j++){
                System.out.print(arr.get(j));
            }
        }
    }

    
    public int setInitialWords(String file) throws IOException{
        Scanner fileReader = new Scanner (new File(file));
        String word = fileReader.nextLine();
        while (fileReader.hasNextLine()){
            ArrayList<Character> arr = new ArrayList<>(5);
            for (int i = 0; i < word.length(); i++){
                arr.add(word.charAt(i));
            }
            possibleAnswers.add(arr);
            word = fileReader.nextLine();
        }
        fileReader.close();
        return 0;
    }
    public String getGuess(){
        return "0";
    }
    public void update(int[] results){

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Model mode = new Model();
    }

}
