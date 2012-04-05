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
public class remove_chars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(args[0]));
            while (input.ready()) {
                final String[] strings = input.readLine().split(",");
                final String charsToRemove = strings[1].trim();
                String charsRemoved = strings[0];
                for (int index = 0; index < charsToRemove.length(); index++) {
                    charsRemoved = charsRemoved.replaceAll(charsToRemove.substring(index, index + 1), "");
                }
                System.out.println(charsRemoved.trim());
            }
        } catch (IOException ex) {
            Logger.getLogger(remove_chars.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
