
import java.io.BufferedReader;
import java.io.File;
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
public class email_regex {

    public email_regex() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new email_regex().run(args[0]);
    }

    public void run(final String filename) {
        File file = new File(filename);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
            }
        } catch (IOException ex) {
            Logger.getLogger(email_regex.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
