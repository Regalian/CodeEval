
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
public class sameend {

    private BufferedReader input;

    public sameend(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new sameend(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final String inputLine = input.readLine();
                if (inputLine.length() > 0) {
                    final String[] inputs = inputLine.split(",");
                    System.out.println((inputs[0].endsWith(inputs[1]))?"1":"0");
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(sameend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
