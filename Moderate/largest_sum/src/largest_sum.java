
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
public class largest_sum {

    private BufferedReader input;

    public largest_sum(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new largest_sum(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final String[] numbers = input.readLine().split(",");
                int[] integers = new int[numbers.length];
                for (int index = 0; index < numbers.length; index++) {
                    integers[index] = Integer.parseInt(numbers[index].trim());
                }
                int maxSum = Integer.MIN_VALUE;
                for (int startRange = 0; startRange < integers.length; startRange++) {
                    for (int endRange = startRange; endRange <= integers.length; endRange++) {
                        int sum = 0;
                        for (int index = startRange; index < endRange; index++) {
                            sum += integers[index];
                        }
                        if (sum > maxSum) {
                            maxSum = sum;
                        }
                    }
                }

                System.out.println(maxSum);
            }
        } catch (IOException ex) {
            Logger.getLogger(largest_sum.class.getName()).log(Level.SEVERE, null, ex);
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
