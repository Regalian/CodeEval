import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
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
public class dupes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(args[0]));
            final Set<String> unique = new TreeSet<String>();
            while (input.ready()) {
                unique.clear();
                final String[] numbers = input.readLine().split(",");
                unique.addAll(Arrays.asList(numbers));
                final String output = unique.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
                System.out.println(output);
            }
        } catch (IOException ex) {
            Logger.getLogger(dupes.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
