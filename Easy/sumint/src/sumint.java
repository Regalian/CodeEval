
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
public class sumint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(args[0]));
            int sum = 0;
            while (input.ready()) {
                sum += Integer.parseInt(input.readLine());
            }
            System.out.println(sum);
        } catch (IOException ex) {
            Logger.getLogger(sumint.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}