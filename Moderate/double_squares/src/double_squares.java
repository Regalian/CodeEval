
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class double_squares {

    private BufferedReader input;
    private List<Integer> squares;

    public double_squares(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
        squares = new ArrayList<Integer>();
        for (int index = 0; index < Math.sqrt(Integer.MAX_VALUE); index++) {
            squares.add(index *index);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new double_squares(args[0]).run();
    }

    void run() {
        try {
            final int numberOfTests = Integer.parseInt(input.readLine());
            for (int count = 0; count < numberOfTests; count++) {
                final int testNumber = Integer.parseInt(input.readLine());
                System.out.println(numberOfSquares(testNumber));
            }
        } catch (IOException ex) {
            Logger.getLogger(double_squares.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    int numberOfSquares(final int number) {
        int count = 0;
        int index = 0;
        while (squares.get(index) <= number / 2) {
            final int remainder = number - squares.get(index);
            if (isASquare(remainder)) {
                count++;
            }
            index++;
        }
        return count;
    }
    
    boolean isASquare(final int number) {
        final int root = (int)Math.round(Math.sqrt(number));
        return (root*root == number);
    }
}
