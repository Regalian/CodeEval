
import java.util.ArrayList;
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
public class sum_prime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new sum_prime().run();
    }

    void run() {
        List<Integer> primes = find_primes(1000);
        int sum = 0;
        for (int prime : primes) {
            sum += prime;
        }
        System.out.println(sum);
    }

    List<Integer> find_primes(int numPrime) {
        List<Integer> primes = new ArrayList<Integer>();
        List<Integer> possiblePrimes = new ArrayList<Integer>(1024);
        primes.add(2);
        int batchSize = 256;
        int lower = 3;
        int upper = lower + batchSize;
        while (primes.size() < numPrime) {
            for (int possible = lower; possible <= upper; possible++) {
                boolean isPossiblePrime = true;
                for (int prime : primes) {
                    isPossiblePrime &= ((possible % prime) != 0);
                }
                if (isPossiblePrime) {
                    possiblePrimes.add(possible);
                }
            }
            int nextPrime = possiblePrimes.remove(0);
            primes.add(nextPrime);
            while (nextPrime < Math.sqrt(upper + 1)) {
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
            possiblePrimes.clear();
            lower = upper + 1;
            upper = lower + batchSize;
        }
        return primes.subList(0, numPrime);
    }
}