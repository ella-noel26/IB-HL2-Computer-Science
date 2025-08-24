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
        JCheckBox checkBox1 = new JCheckBox();
        checkBoxPanel.add(checkBox1);
        checkBoxPanel.add(new JCheckBox());

        panel.add(checkBoxPanel, borderLayoutManager.WEST);
    
        panel.setBorder(BorderFactory.createDashedBorder(Color.black));
        window.setContentPane(panel);

        
        
        
        
        window.setVisible(true);
    }



    public static void main(String[] args){
        createGUI();
    }
}
