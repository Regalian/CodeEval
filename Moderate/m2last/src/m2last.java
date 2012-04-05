
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
public class m2last {

    private BufferedReader input;

    public m2last(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new m2last(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final String inputLine = input.readLine();
                if (inputLine.length() > 0) {
                    final String[] inputs = inputLine.split(" ");
                    final int m = Integer.parseInt(inputs[inputs.length - 1]);
                    final int index = inputs.length -1 - m;
                    if (index >= 0) {
                        System.out.println(inputs[index]);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(m2last.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
