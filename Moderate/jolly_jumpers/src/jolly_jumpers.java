
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
public class jolly_jumpers {

    private BufferedReader input;

    public jolly_jumpers(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new jolly_jumpers(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final String inputLine = input.readLine();
                if (inputLine.length() > 0) {
                    final String[] inputs = inputLine.split(" ");
                    final int count = Integer.parseInt(inputs[0]);
                    final int[] numbers = new int[count];
                    for (int index = 0; index < count; index++) {
                        numbers[index] = Integer.parseInt(inputs[index + 1]);
                    }
                    final int[] diffs = new int[count - 1];
                    for (int index = 0; index < (count - 1); index++) {
                        diffs[index] = Math.abs(numbers[index] - numbers[index+1]);
                    }
                    Arrays.sort(diffs);
                    boolean jollyJumper = true;
                    for (int index = 0; index < count - 1; index++) {
                        jollyJumper &= (diffs[index] == (index + 1));
                    }
                    
                    System.out.println(jollyJumper ? "Jolly" : "Not jolly");
                }              
            }
        } catch (IOException ex) {
            Logger.getLogger(jolly_jumpers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
