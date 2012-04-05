
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
public class reverse_words {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(args[0]));
            while (input.ready()) {
               final String inputLine = input.readLine();
                if (inputLine.trim().length() > 0) {
                    final String[] words = inputLine.split("\\s+");
                    for (int index = words.length; index > 0; index--) {
                        System.out.print(words[index - 1] + (index > 1 ? " " : ""));
                    }
                    System.out.println();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(reverse_words.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
