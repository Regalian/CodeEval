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
                final String[] inputs;
                inputs = input.readLine().replace('(',' ').replace(')',' ')
                        .replace(',',' ').trim().split("\\s+");
                int[] coords = new int[4];
                int dist = 0;
                for (int i = 0; i < 4; i++) {
                    coords[i] = Integer.parseInt(inputs[i]);
                    dist = (coords[2] - coords[0]) * (coords[2] - coords[0])
                            + (coords[3] - coords[1]) * (coords[3] - coords[1]);
                }
                System.out.println((int)Math.sqrt(dist));
            }
        } catch (IOException ex) {
            getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
    }

}
