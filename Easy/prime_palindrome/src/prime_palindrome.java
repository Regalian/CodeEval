
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author richard
 */
public class prime_palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new prime_palindrome().run();
    }

    void run() {
        List<Integer> primes = find_primes(1000);
        Collections.reverse(primes);
        for (int prime: primes) {
            if (isPalindrome(prime)) {
                System.out.println(prime);
                break;
            }
        }
    }

    List<Integer> find_primes(int maxPrime) {
        List<Integer> primes = new ArrayList<Integer>();
        List<Integer> possiblePrimes = new ArrayList<Integer>(maxPrime / 2);
        primes.add(2);
        for (int possible = 3; possible <= maxPrime; possible+=2) {
            possiblePrimes.add(possible);
        }
        int nextPrime = possiblePrimes.remove(0);
        primes.add(nextPrime);
        while (nextPrime < Math.sqrt(maxPrime + 1)) {
            ListIterator<Integer> it = possiblePrimes.listIterator();
            List<Integer> toRemove = new ArrayList<Integer>();
            while (it.hasNext()) {
                int possiblePrime = it.next();
                if (possiblePrime % nextPrime == 0) {
                    toRemove.add(possiblePrime);
                }
            }
            possiblePrimes.removeAll(toRemove);
            nextPrime = possiblePrimes.remove(0);
            primes.add(nextPrime);
        }
        primes.addAll(possiblePrimes);
        return primes;
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