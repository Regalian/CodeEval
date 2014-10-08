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
                String[] parts = input.readLine().split("[\\[\\]]");
                String[] items = parts[1].trim().split("\\,");
                int sum = 0;
                for (int i = 0; i < items.length; i++) {
                    if (items[i].contains("label")) {
                        String[] ids = items[i - 1].split(":");
                        sum += Integer.parseInt(ids[1].trim());
                    }
                }
                System.out.println(sum);
            }
        } catch (IOException ex) {
            getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
    }

}
