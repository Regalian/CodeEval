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
public class position {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(args[0]));
            while (input.ready()) {
                final String[] numbers = input.readLine().split(",");
                final int number = Integer.parseInt(numbers[0]);
                final int position1 = Integer.parseInt(numbers[1]);
                final int position2 = Integer.parseInt(numbers[2]);
                final int bit1 = number >> (position1 - 1);
                final int bit2 = number >> (position2 - 1);
                System.out.println((bit1 & 1) == (bit2 & 1));
            }
        } catch (IOException ex) {
            Logger.getLogger(position.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
