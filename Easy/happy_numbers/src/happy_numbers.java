
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class happy_numbers {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        new happy_numbers().run(args[0]);
    }

    private void run(final String inputFile) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(inputFile));
            final List<Integer> seenNumbers = new ArrayList<Integer>();
            while (input.ready()) {
                String inputLine = input.readLine();
                seenNumbers.clear();
                while (true) {
                    final Integer sumOfDisgits = sumDigits(inputLine);
                    if (sumOfDisgits == 1) {
                        System.out.println("1");
                        break;
                    } else if (seenNumbers.contains(sumOfDisgits)) {
                        System.out.println("0");
                        break;
                    } else {
                        seenNumbers.add(sumOfDisgits);
                        inputLine = sumOfDisgits.toString();
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(happy_numbers.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    private Integer sumDigits(final String input) {
        int sum = 0;
        for (char digit : input.toCharArray()) {
            final int value = (digit - '0');
            sum += (value * value);
        }
        return sum;
    }
}
