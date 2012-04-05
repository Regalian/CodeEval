
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
public class num_of_ones {

    private BufferedReader input;

    public num_of_ones(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new num_of_ones(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final String number = input.readLine();
                final int intNumber = Integer.parseInt(number);
                int numberOfOnes = Integer.bitCount(intNumber);
                System.out.println(numberOfOnes);
            }
        } catch (IOException ex) {
            Logger.getLogger(num_of_ones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
