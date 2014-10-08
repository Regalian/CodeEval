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
                String[] numbers = input.readLine().trim().split("\\s+");
                int[] nos = new int[numbers.length];
                int[] counts = new int[10];
                for (int i = 0; i < numbers.length; i++) {
                    nos[i] = Integer.parseInt(numbers[i].trim());
                    counts[nos[i]]++;
                }
                int pos = -1;
                for (int i = 1; i < 10; i++) {
                    if (counts[i] == 1) {
                        pos = i;
                        break;
                    }
                }
                if (pos != -1) {
                    int hit = 0;
                    for (int i = 0; i < numbers.length; i++) {
                        if (pos == nos[i]) {
                            System.out.println(i + 1);
                            break;
                        }
                    }
                } else {
                    System.out.println(0);
                }
            }
        } catch (IOException ex) {
            getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
    }

}
