import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author richard
 */
public class Main {

    private static final Logger LOG = getLogger(Main.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(args[0]));
            while (input.ready()) {
                String line = input.readLine();
                char first = line.charAt(0);
                boolean found = false;
                int next = 1;
                while (!found) {
                    next = line.indexOf(first, next);
                    if (next > 0) {
                        String part1 = line.substring(0, next);
                        String part2 = line.substring(next, next + next);
                        if (part1.equals(part2)) {
                            System.out.println(part1.length());
                            found = true;
                        }
                    } else {
                        break;
                    }
                }
                if (!found) {
                    System.out.println(line.length());
                }

            }
        } catch (IOException ex) {
            getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
    }

}
