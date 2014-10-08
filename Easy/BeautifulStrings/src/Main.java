import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Arrays;
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
                final String line = input.readLine().trim().toLowerCase();
                System.out.println(beauty(line));
            }
        } catch (IOException ex) {
            getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
    }

    private static int beauty(final String line) {
        int sum = 0;
        int[] counts = new int[26];
        for (char c: line.toCharArray()) {
            if (Character.isLetter(c)) counts[c - 'a']++;
        }
        Arrays.sort(counts);
        for (int i = 0, j = 1; i < 26; i++, j++ ) {
            sum += counts[i] * j;
        }
        return sum;
    }

}
