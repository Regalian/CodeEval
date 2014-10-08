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
    private static byte[][] board = new byte[256][256];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(args[0]));
            while (input.ready()) {
                final String[] inputs;
                inputs = input.readLine().split("\\s+");
                runQuery(inputs);
            }
        } catch (IOException ex) {
            getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
    }

    private static void runQuery(final String[] inputs) {
        switch (inputs[0]) {
            case "SetCol": {
                int column = Integer.parseInt(inputs[1]);
                byte value = Byte.parseByte(inputs[2]);
                for (int row = 0; row < 256; row++) {
                    board[row][column] = value;
                }
                break;
            }
            case "SetRow": {
                int row = Integer.parseInt(inputs[1]);
                byte value = Byte.parseByte(inputs[2]);
                for (int column = 0; column < 256; column++) {
                    board[row][column] = value;
                }
                break;
            }
            case "QueryRow": {
                int row = Integer.parseInt(inputs[1]);
                int sum = 0;
                for (int column = 0; column < 256; column++) {
                    sum += board[row][column];
                }
                System.out.println(sum);
                break;
            }
            case "QueryCol": {
                int column = Integer.parseInt(inputs[1]);
                int sum = 0;
                for (int row = 0; row < 256; row++) {
                    sum += board[row][column];
                }
                System.out.println(sum);
                break;
            }
        }
    }

}
