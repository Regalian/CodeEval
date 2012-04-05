
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class dec2bin {

    private BufferedReader input;

    public dec2bin(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new dec2bin(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final Integer decimal = Integer.decode(input.readLine());
                System.out.println(Integer.toBinaryString(decimal));
            }
        } catch (IOException ex) {
            Logger.getLogger(dec2bin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    List<Integer> find_palindromes(int start, int end) {
        List<Integer> palindromes = new ArrayList<Integer>();
        for (int possible = start; possible <= end; possible++) {
            if (isPalindrome(possible)) {
                palindromes.add(possible);
            }
        }
        return palindromes;
    }

    boolean isPalindrome(int value) {
        String stringValue = Integer.toString(value);
        boolean isPalindrome = true;
        for (int first = 0, last = stringValue.length() - 1; first <= last; first++, last--) {
            isPalindrome &= stringValue.charAt(first) == stringValue.charAt(last);
        }
        return isPalindrome;
    }
}
