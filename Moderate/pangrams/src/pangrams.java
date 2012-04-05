
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
public class pangrams {

    private BufferedReader input;
    private final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public pangrams(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new pangrams(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final String inputLine = input.readLine().toLowerCase();
                String output = ALPHABET;
                for (int index = 0; index < inputLine.length(); index++) {
                    String letter = inputLine.substring(index, index + 1);
                    if (ALPHABET.contains(letter)) {
                        output = output.replaceAll(letter, "");
                    }
                }
                if (output.length() > 0) {
                    System.out.println(output);
                } else {
                    System.out.println("NULL");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(pangrams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
