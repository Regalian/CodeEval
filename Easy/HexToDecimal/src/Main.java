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
                final String hex = input.readLine();
                System.out.println(hex2dec(hex));
            }
        } catch (IOException ex) {
            getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
    }

    private static int hex2dec(final String hex) {
        int dec = 0;
        for (char c : hex.toCharArray()) {
            int n;
            if (Character.isDigit(c)) {
                n = c - '0';
            } else {
                n = c - 'a' + 10;
            }
            dec = dec * 16 + n;
        }
        return dec;
    }

}
