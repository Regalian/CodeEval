
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
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
public class cycle_detection {

    private BufferedReader input;

    public cycle_detection(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new cycle_detection(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final String inputLine = input.readLine();
                if (inputLine.length() > 0) {
                    final String[] values = inputLine.split(" ");
                    Integer[] result = brent(values);
                    if (result.length > 0) {
                        StringBuilder output = new StringBuilder();
                        output.append(result[0]);
                        for (int index = 1; index < result.length; index++) {
                            output.append(" ").append(result[index]);
                        }
                        System.out.println(output.toString());
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(cycle_detection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Integer[] brent(String[] values) {
        int power = 1;
        int lambda = 1;
        int tortoise = 0;
        int hare = 1;
        while (!values[tortoise].equals(values[hare])) {
            if (power == lambda) {
                tortoise = hare;
                power *= 2;
                lambda = 0;
            }
            hare++;
            if (hare >= values.length) {
                return new Integer[0];
            }
            lambda++;
        }

        int mu = 0;
        hare = 0;
        tortoise = hare;
        hare += lambda;
        while (!values[tortoise].equals(values[hare])) {
            tortoise++;
            hare++;
            mu++;
        }
        
        Integer[] result = new Integer[lambda];
        for (int index = 0; index < lambda; index++) {
            result[index] = Integer.parseInt(values[mu + index]);
        }
        return result;
    }
}
