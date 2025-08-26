package source;
import javax.swing.*;
import java.awt.*; //Ask Vawdrey what this does?

public class main {
    public static void createGUI(){
        JFrame window = new JFrame("Wordle Solver");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension windowDimension = new Dimension(500,500);
        window.setSize(windowDimension);
        //window.setResizable(false);
        
        JPanel panel = new JPanel(new GridBagLayout());
        BorderLayout borderLayoutManager = new BorderLayout();
        panel.setLayout(borderLayoutManager);

        JTextArea instructions = new JTextArea("Hello! This is a wordle solver. A word will appear for you to enter in wordle, once you have done so click on each letter as the colors appear in wordle. Then click the checkbox to the left, it will then give you the next word or you have won.");
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);
        instructions.setEditable(false);
        instructions.setFont(new Font("SansSerif", Font.BOLD, 18));
        panel.add(instructions, borderLayoutManager.NORTH);

        JPanel checkBoxPanel = new JPanel();
        BoxLayout checkBoxLayout = new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS);
        checkBoxPanel.setLayout(checkBoxLayout);
        
        JCheckBox[] checkBoxs = new JCheckBox[6];
        for (int i = 0; i < 6; i++){
            checkBoxs[i] = new JCheckBox();
            checkBoxPanel.add(checkBoxs[i]);
        }

        ImageIcon uncheckedIcon = new ImageIcon("images\\unchecked.png");
        ImageIcon checkedIcon = new ImageIcon("images\\checked.png");
        //System.out.println(window.getHeight());
        //System.out.println(instructions.getPreferredSize().height);
        //System.out.println(instructions.getPreferredSize().height* instructions.getLineCount());
        //System.out.println((window.getHeight()-(instructions.getPreferredSize().height * instructions.getLineCount()))/7);
        //updateCheckboxIcons(checkBoxs, (window.getHeight()-(instructions.getPreferredSize().height * instructions.getLineCount()))/7, uncheckedIcon, checkedIcon);
        //Image uncheckedImage = uncheckedIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        //Image checkedImage = checkedIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        
        /*JCheckBox checkBox1 = new JCheckBox();
        checkBox1.setIcon(new ImageIcon(uncheckedImage));
        checkBox1.setSelectedIcon(new ImageIcon(checkedImage));
        checkBoxPanel.add(checkBox1);

        JCheckBox checkBox2 = new JCheckBox();
        checkBox2.setIcon(new ImageIcon(uncheckedImage));
        checkBox2.setSelectedIcon(new ImageIcon(checkedImage));
        checkBoxPanel.add(checkBox2);  

        JCheckBox checkBox3 = new JCheckBox();
        checkBox3.setIcon(new ImageIcon(uncheckedImage));
        checkBox3.setSelectedIcon(new ImageIcon(checkedImage));
        checkBoxPanel.add(checkBox3);      

        JCheckBox checkBox4 = new JCheckBox();
        checkBox4.setIcon(new ImageIcon(uncheckedImage));
        checkBox4.setSelectedIcon(new ImageIcon(checkedImage));
        checkBoxPanel.add(checkBox4);      

        JCheckBox checkBox5 = new JCheckBox();
        checkBox5.setIcon(new ImageIcon(uncheckedImage));
        checkBox5.setSelectedIcon(new ImageIcon(checkedImage));
        checkBoxPanel.add(checkBox5);

        JCheckBox checkBox6 = new JCheckBox();
        checkBox6.setIcon(new ImageIcon(uncheckedImage));
        checkBox6.setSelectedIcon(new ImageIcon(checkedImage));
        checkBoxPanel.add(checkBox6);*/
        
        panel.add(checkBoxPanel, borderLayoutManager.WEST);

        JPanel wordGridPanel = new JPanel();
        GridLayout wordGridLayout = new GridLayout(6, 5);
        wordGridPanel.setLayout(wordGridLayout);
        JButton[][] wordGridButtons = new JButton[6][5];
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 5; j++){
                wordGridButtons[i][j] = new JButton();
                wordGridPanel.add(wordGridButtons[i][j]);
            }
        }
        panel.add(wordGridPanel, borderLayoutManager.CENTER);

        updateCheckboxIcons(checkBoxs, window.getWidth()/ 7,  uncheckedIcon, checkedIcon);

    
        panel.setBorder(BorderFactory.createDashedBorder(Color.black));
        window.setContentPane(panel);

        
        
        
        
        window.setVisible(true);
    }

    public static void updateCheckboxIcons(JCheckBox[] arr, int width, ImageIcon uncheckedIcon, ImageIcon checkedIcon){
        for (int i = 0; i < arr.length; i++){
            arr[i].setIcon(new ImageIcon(uncheckedIcon.getImage().getScaledInstance(width, width, Image.SCALE_SMOOTH)));
            arr[i].setSelectedIcon(new ImageIcon(checkedIcon.getImage().getScaledInstance(width, width, Image.SCALE_SMOOTH)));

        }
    }

    public static void main(String[] args){
        createGUI();
    }
}
