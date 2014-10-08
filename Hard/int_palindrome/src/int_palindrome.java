
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author richard
 */
public class int_palindrome {
    private static final Logger LOG = getLogger(int_palindrome.class.getName());

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        new int_palindrome(args[0]).run();
    }

    private final BufferedReader input;

    /**
     *
     * @param inputFilename
     * @throws FileNotFoundException
     */
    public int_palindrome(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    private void run() {
        try {
            while (input.ready()) {
                final String[] range = input.readLine().split(" ");
                int start = parseInt(range[0]);
                int end = parseInt(range[1]);
                List<Integer> palindromes = find_palindromes(start, end);
                int numberOfRanges = 0;
                for (int startRange = start; startRange <= end; startRange++) {
                    for (int endRange = startRange; endRange <= end; endRange++) {
                        int numberOfPalindromes = 0;
                        for (int test = startRange; test <= endRange; test++) {
                            if (palindromes.contains(test)) {
                                numberOfPalindromes++;
                            }
                        }
                        if ((numberOfPalindromes % 2) == 0) {
                            numberOfRanges++;
                        }
                    }
                }

                System.out.println(numberOfRanges);
            }
        } catch (IOException ex) {
            getLogger(int_palindrome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<Integer> find_palindromes(int start, int end) {
        List<Integer> palindromes = new ArrayList<>();
        for (int possible = start; possible <= end; possible++) {
            if (isPalindrome(possible)) {
                palindromes.add(possible);
            }
        }
        return palindromes;
    }

    private boolean isPalindrome(int value) {
        String stringValue = Integer.toString(value);
        boolean isPalindrome = true;
        for (int first = 0, last = stringValue.length() - 1; first <= last; first++, last--) {
            isPalindrome &= stringValue.charAt(first) == stringValue.charAt(last);
        }
        return isPalindrome;
    }
}
