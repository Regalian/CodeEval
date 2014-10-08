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
                String[] parts = input.readLine().split(":");
                String[] list = parts[0].split("\\s+");
                String[] positions = parts[1].split("\\,");
                for (String position: positions) {
                    String[] pos = position.trim().split("\\-");
                    int first = Integer.parseInt(pos[0].trim());
                    int second = Integer.parseInt(pos[1].trim());
                    String temp = list[first];
                    list[first] = list[second];
                    list[second] = temp;
                }
                for(String element: list) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        } catch (IOException ex) {
            getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
    }

}
