
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author richard
 */
public class reverse_add {

    private BufferedReader input;

    public reverse_add(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new reverse_add(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final String inputLine = input.readLine();
                if (inputLine.length() > 0) {
                    int number = Integer.parseInt(inputLine);
                    int iterations = 0;
                    while (!isPalindrome(number)) {
                        final int reversed = reverseNumber(number);
                        number += reversed;
                        iterations++;
                    }
                    System.out.println(Integer.toString(iterations) + " " + Integer.toString(number));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(reverse_add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean isPalindrome(int value) {
        String stringValue = Integer.toString(value);
        boolean isPalindrome = true;
        for (int first = 0, last = stringValue.length() - 1; first <= last; first++, last--) {
            isPalindrome &= stringValue.charAt(first) == stringValue.charAt(last);
        }
        return isPalindrome;
    }

    int reverseNumber(final int number) {
        String sNumber = Integer.toString(number);
        StringBuilder reverse = new StringBuilder(sNumber.length());
        for (int index = sNumber.length() - 1; index >= 0; index--) {
            reverse.append(sNumber.charAt(index));
        }
        return Integer.parseInt(reverse.toString());
    }
}
