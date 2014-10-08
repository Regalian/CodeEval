import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
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
public class array_absurdity {

    private BufferedReader input;

    public array_absurdity(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new array_absurdity(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final String inputLine = input.readLine();
                if (inputLine.length() > 0) {
                    final String[] inputs = inputLine.split(";");
                    final int n = parseInt(inputs[0]);
                    final int[] counts = new int[n - 1];
                    final String[] entries = inputs[1].split(",");
                    for (String entry : entries) {
                        final int index = parseInt(entry);
                        counts[index]++;
                        if (counts[index] > 1) {
                            System.out.println(index);
                            break;
                        }
                    }
                }
            }
        } catch (IOException ex) {
            getLogger(array_absurdity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
