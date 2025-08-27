
import java.io.File;
import APClasses.IBIO;

public class ConsoleApp {
    public static void main(String[] args) {
        Controller controller = new Controller();
        IBIO console = new IBIO();

        console.output("Welcome to the wordle solver\n");
        while (true) {
            console.output("Your new guess is " + String.valueOf(controller.reportGuess()) + "\n");
            System.out.println("console");
            for (int i = 0; i < 5; i++) {
                controller.setColor(i, console.inputInt("Please input the result of the " + String.valueOf(i + 1)
                        + " letter (gray=0, yellow=1, green=2)"));
            }
            controller.submit();
        }
    }
}
