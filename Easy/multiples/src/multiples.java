
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
public class multiples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(args[0]));
            while (input.ready()) {
                String[] numbers = input.readLine().split(",");
                int x = Integer.parseInt(numbers[0]);
                int n = Integer.parseInt(numbers[1]);
                int current = n;
                while (x > current) {
                    current += n;
                }
                System.out.println(current);
            }
        } catch (IOException ex) {
            Logger.getLogger(multiples.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
