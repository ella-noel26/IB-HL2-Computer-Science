import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.lang.reflect.Array;

public class Model implements WordleModel{
    
    private ArrayList<ArrayList<Character>> wordsAndPoints;
    private int[][] letterOccurences;
    private String lastSentGuess;

    public Model(){
        this.wordsAndPoints = new ArrayList<>(2500);
        this.letterOccurences = new int[26][5];
        this.lastSentGuess = "";
        try {
            setInitialWords("lib\\wordsYves.txt");
        } 
        catch (IOException e){
            System.out.println("Didn't work....");
        }
    }

    
    public int setInitialWords(String file) throws IOException{
        Scanner fileReader = new Scanner (new File(file));
        if (!fileReader.hasNextLine()){
            fileReader.close();
            return -1;
        }
        String word = fileReader.nextLine().toLowerCase();
        while (true){
            ArrayList<Character> arr = new ArrayList<>(5);
            for (int i = 0; i < word.length(); i++){
                arr.add(word.charAt(i));
            }
            wordsAndPoints.add(arr);
            if (!fileReader.hasNextLine()){
                break;
            }
            word = fileReader.nextLine().toLowerCase();
        }
        fileReader.close();
        
        updateOccurences();
    
        return this.wordsAndPoints.size();
    }

    private void updateOccurences(){
        for (int i = 0; i < wordsAndPoints.size(); i++){
            for (int j = 0; j < 5; j++){
                letterOccurences[wordsAndPoints.get(i).get(j)-97][j] += 1;
            }
        }
    }

    private int getPoints(ArrayList<Character> word){
        int points = 0;
        for (int j = 0; j < 5; j++){
            for (int k = 0; k < 5; k++){
                points += letterOccurences[word.get(j)-97][k];
            }
            points += letterOccurences[word.get(j)-97][j];
        }
        return points;
    }

    public String getGuess(){
        int largestPointValue = 0;
        String guess = "     ";
        for (int i = 0; i < wordsAndPoints.size(); i++){
            int pointsOfCurrentWord = getPoints(wordsAndPoints.get(i));
            if (pointsOfCurrentWord > largestPointValue){
                largestPointValue = pointsOfCurrentWord;
                guess = Character.toString(wordsAndPoints.get(i).get(0));
                guess += Character.toString(wordsAndPoints.get(i).get(1));
                guess += Character.toString(wordsAndPoints.get(i).get(2));
                guess += Character.toString(wordsAndPoints.get(i).get(3));
                guess += Character.toString(wordsAndPoints.get(i).get(4));
            }
        }
        this.lastSentGuess = guess;
        return guess;
    }
    
    public void update(int[] results){
        System.out.println("update");
        ArrayList<Character> lastGuess = new ArrayList<>(5);
        lastGuess.add(lastSentGuess.charAt(0));
        lastGuess.add(lastSentGuess.charAt(1));
        lastGuess.add(lastSentGuess.charAt(2));
        lastGuess.add(lastSentGuess.charAt(3));
        lastGuess.add(lastSentGuess.charAt(4));
        for (int i = wordsAndPoints.size() - 1; i >= 0; i--){
            boolean removed = false;
            if (!removed){
                for (int j = 0; j < results.length; j++){
                    if (!removed){
                        //need to fix when i have greys
                        if (results[j] == 0 && lastGuess.get(j) == wordsAndPoints.get(i).get(j)){
                            wordsAndPoints.remove(i);
                            removed = true;
                        } //removes word if it had a gray letter 
                        //these need to look at the occurences in word being tested which isnt word beind entered
                        else if (results[j] == 0 && containsChar(lastGuess.get(j), wordsAndPoints.get(i)) && occurencesOfLetter(lastGuess, lastGuess.get(j)) == 1){
                            wordsAndPoints.remove(i);
                            removed = true;
                        } //removes word if it has a letter that was gray at another spot and the letter is only there one time, 5/22/2025 isnt working
                        
                        else if (results[j] == 0 && occurencesOfLetter(wordsAndPoints.get(i), lastGuess.get(j)) > 1){
                            System.out.println(i);
                            int[] whereLetterIs = new int[5];
                            for (int y = 0; y < 5; y++){
                                whereLetterIs[y] = 0;
                                if (lastGuess.get(y) == lastGuess.get(j)){
                                    whereLetterIs[y] = results[y];
                                }
                            }
                            boolean shouldRemove = true;
                            for (int x = 0; x < 5; x++){
                                if (whereLetterIs[x] == 1 && shouldRemove){
                                    shouldRemove = false;
                                }
                            }
                            if (shouldRemove){
                                wordsAndPoints.remove(i);
                                removed = true;
                            }
                        }
                        
                        else if (results[j] == 1 && !containsCharNotHere(lastGuess.get(j), wordsAndPoints.get(i), j)){
                            wordsAndPoints.remove(i);
                            removed = true;
                        }
                        else if (results[j] == 2 && lastGuess.get(j) != wordsAndPoints.get(i).get(j)){
                            wordsAndPoints.remove(i);
                            removed = true;
                        }
                    }
                }
            }
        }
        updateOccurences();
    }

    private int occurencesOfLetter(ArrayList<Character> word, char c){
        int o = 0;
        for (int i = 0; i < 5; i++){
            if (word.get(i) == c){
                o += 1;
            }
        }
        return o;
    }



    private boolean containsChar(char letter, ArrayList<Character> word){
        for (int i = 0; i < word.size(); i++){
            if (letter == word.get(i)){
                return true;
            }
        }
        return false;
    }

    private boolean containsCharNotHere(char letter, ArrayList<Character> word, int position){
        for (int i = 0; i < word.size(); i++){
            if (letter == word.get(i) && i != position){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Model mode = new Model();
    }

}
