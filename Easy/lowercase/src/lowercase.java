import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author richard
 */
public class lowercase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(args[0]));
            while (input.ready()) {
                final String inputLine = input.readLine();
                System.out.println(inputLine.toLowerCase());
            }
        } catch (IOException ex) {
            Logger.getLogger(lowercase.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
