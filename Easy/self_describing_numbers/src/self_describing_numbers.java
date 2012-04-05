
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
public class self_describing_numbers {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        new self_describing_numbers().run(args[0]);
    }

    private void run(final String inputFile) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(inputFile));
            while (input.ready()) {
                final String inputLine = input.readLine();
                final char[] inputDigits = inputLine.toCharArray();
                int[] digits = new int[inputDigits.length];
                for (char inputDigit : inputDigits) {
                    if ((inputDigit - '0') < inputDigits.length) {
                        digits[inputDigit - '0']++;
                    }
                }
                boolean selfDescribing = true;
                for (int index = 0; index < inputDigits.length; index++) {
                    selfDescribing &= (digits[index] == (inputDigits[index] - '0'));
                }
                System.out.println("" + (selfDescribing ? "1" : "0"));
            }
        } catch (IOException ex) {
            Logger.getLogger(self_describing_numbers.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
