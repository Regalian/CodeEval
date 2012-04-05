
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
public class prime_less {

    private BufferedReader input;

    public prime_less(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new prime_less(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final long maxPrime = Long.parseLong(input.readLine());
                List<Long> primes = find_primes(maxPrime);
                final String output = primes.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
                System.out.println(output);
            }
        } catch (IOException ex) {
            Logger.getLogger(prime_less.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    List<Long> find_primes(long maxPrime) {
        List<Long> primes = new ArrayList<Long>();
        List<Long> possiblePrimes = new ArrayList<Long>();
        primes.add(2l);
        for (long possible = 3; possible <= maxPrime; possible+=2) {
            possiblePrimes.add(possible);
        }
        Long nextPrime = possiblePrimes.remove(0);
        primes.add(nextPrime);
        while (nextPrime < Math.sqrt(maxPrime + 1)) {
            ListIterator<Long> it = possiblePrimes.listIterator();
            List<Long> toRemove = new ArrayList<Long>();
            while (it.hasNext()) {
                long possiblePrime = it.next();
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
}
