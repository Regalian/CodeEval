
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author richard
 */
public class rightmost {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(args[0]));
            while (input.ready()) {
                final String inputLine = input.readLine();
                if (inputLine.length() > 0) {
                    final String[] inputs = inputLine.split(",");
                    final String source = inputs[0];
                    final char target = inputs[1].charAt(0);
                    int position;
                    for (position = source.length() - 1; position >= 0; position--) {
                        if (source.charAt(position) == target) {
                            break;
                        }
                    }
                    System.out.println(Integer.toString(position));
                }
            }
        } catch (IOException ex) {
            getLogger(rightmost.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
    }
}
