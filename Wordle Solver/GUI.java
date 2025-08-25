package source;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*; //Ask Vawdrey what this does?

public class GUI {
    
    public GUI(){
        JFrame window = new JFrame("Wordle Solver");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension windowDimension = new Dimension(800,800);
        window.setSize(windowDimension);

        JPanel panel = new JPanel(new GridBagLayout());
        BorderLayout borderLayoutManager = new BorderLayout();
        panel.setLayout(borderLayoutManager);

        JTextArea instructions = new JTextArea("Hello! This is a wordle solver. A word will appear for you to enter in wordle, once you have done so click on each letter as the colors appear in wordle. Then click the submit button to the left, it will then give you the next word or you have won.");
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);
        instructions.setEditable(false);
        instructions.setFont(new Font("SansSerif", Font.BOLD, 18));
        instructions.setBackground(new Color(225,157,171));
        panel.add(instructions, borderLayoutManager.NORTH);

        JTextArea finishingWords = new JTextArea("Congrats! You won because of me, kind of embarrassing but you do you!");
        finishingWords.setEditable(false);
        finishingWords.setFont(new Font("SansSerif", Font.BOLD, 18));
        finishingWords.setBackground(new Color(225,157,171));
        panel.add(finishingWords, borderLayoutManager.SOUTH);


        /*JPanel submitBoxPanel = new JPanel();
        BoxLayout checkBoxLayout = new BoxLayout(submitBoxPanel, BoxLayout.Y_AXIS);
        submitBoxPanel.setLayout(checkBoxLayout);*/
        Border paddingBorder = BorderFactory.createLineBorder(Color.BLACK, 30);
        Border ellaFrandsen = BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(225,157,171), new Color(173,113,125));
        JPanel[] submitBorderPanels = new JPanel[6];
        JButton[] submitButtons = new JButton[6];
        JPanel wordGridPanel = new JPanel();
        GridLayout wordGridLayout = new GridLayout(6, 6);
        wordGridPanel.setLayout(wordGridLayout);
        JButton[][] wordGridButtons = new JButton[6][5];
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                if (j==0){
                    JPanel borderPanel = new JPanel();
                    submitBorderPanels[i] = borderPanel;
                    borderPanel.setBorder(ellaFrandsen);
                    GridLayout layout = new GridLayout(1, 1);
                    borderPanel.setLayout(layout);
                    wordGridPanel.add(borderPanel);
                    JButton button = new JButton();
                    if(i==3){
                        button.setText("Submitted");
                        button.setFont(new Font("SansSerif", Font.BOLD, 16));
                        button.setBackground(new Color(97,97,97));
                    }
                    else{
                        button.setText("Submit");
                        button.setFont(new Font("SansSerif", Font.BOLD, 16));
                        button.setBackground(new Color(230,230,230));
                    }

                    //button.setBackground(new Color(225,225,225));
                    //button.setBackground(new Color(225,157,171));
                    borderPanel.add(button);
                    submitButtons[i] = button;
                }
                else{
                    wordGridButtons[i][j-1] = new JButton();
                    if (i == 1 && j ==3){
                        wordGridButtons[i][j-1].setBackground(new Color(200,182,83));
                        wordGridButtons[i][j-1].setText("M");
                        wordGridButtons[i][j-1].setFont(new Font("SansSerif", Font.BOLD, 45));


                    }
                    else if (i == 2 && j ==4){
                        wordGridButtons[i][j-1].setBackground(new Color(108,169,101));
                        wordGridButtons[i][j-1].setText("S");
                        wordGridButtons[i][j-1].setFont(new Font("SansSerif", Font.BOLD, 45));
                    }
                    else if (i == 1 && j ==2){
                        wordGridButtons[i][j-1].setBackground(new Color(120,124,127));
                        wordGridButtons[i][j-1].setText("K");
                        wordGridButtons[i][j-1].setFont(new Font("SansSerif", Font.BOLD, 45));
                    }
                    else{
                        wordGridButtons[i][j-1].setBackground(new Color(255,255,255));
                    }
                    wordGridPanel.add(wordGridButtons[i][j-1]);
                }
            }
        }
        panel.add(wordGridPanel, borderLayoutManager.CENTER);

        panel.setBorder(BorderFactory.createDashedBorder(Color.black));
        panel.setBorder(BorderFactory.createLineBorder(new Color(225,157,171), 10));
        window.setContentPane(panel);

        window.setVisible(true);
    }

    public static void main(String[] args){
        GUI gui = new GUI();
    }
}
