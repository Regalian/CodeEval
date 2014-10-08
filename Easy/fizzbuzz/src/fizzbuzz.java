
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author richard
 */
public class fizzbuzz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(args[0]));
            while (input.ready()) {
                String[] numbers = input.readLine().split(" ");
                int fizz = parseInt(numbers[0]);
                int buzz = parseInt(numbers[1]);
                int limit = parseInt(numbers[2]);

                for (int counter = 1; counter <= limit; counter++) {
                    if (!(counter % fizz == 0 || counter % buzz == 0)) {
                        System.out.print(counter);
                    }
                    if (counter % fizz == 0) {
                        System.out.print("F");
                    }
                    if (counter % buzz == 0) {
                        System.out.print("B");
                    }
                    if (counter < limit) {
                        System.out.print(" ");
                    } else {
                        System.out.println();;
                    }
                }

            }
        } catch (IOException ex) {
            getLogger(fizzbuzz.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
    }
}
