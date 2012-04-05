
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
public class longestlines {
    List<String> lines;
    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        new longestlines().run(args[0]);
    }

    public longestlines() {
        lines = new ArrayList<String>();
    }
    
    private void run(final String inputFile) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(inputFile));
            int  numberOfLines = Integer.parseInt(input.readLine());
            while (input.ready()) {
                final String inputLine = input.readLine();
                if (inputLine.length() > 0) {
                    lines.add(inputLine);
                }
            }
            Collections.sort(lines, new Comparator<String>() {

                public int compare(String t, String t1) {
                    return t1.length() - t.length();
                }
            });
            for (int lineNo = 0; lineNo < numberOfLines; lineNo++) {
                System.out.println(lines.get(lineNo));
            }
        } catch (IOException ex) {
            Logger.getLogger(longestlines.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}
