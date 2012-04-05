
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
public class sum_digits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(args[0]));
            while (input.ready()) {
                final String number = input.readLine();
                int sum = 0;
                for (char digit : number.toCharArray()) {
                    sum += (digit - '0');
                }
                System.out.println(sum);
            }
        } catch (IOException ex) {
            Logger.getLogger(sum_digits.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
