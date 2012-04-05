
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                int fizz = Integer.parseInt(numbers[0]);
                int buzz = Integer.parseInt(numbers[1]);
                int limit = Integer.parseInt(numbers[2]);

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
            Logger.getLogger(fizzbuzz.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
