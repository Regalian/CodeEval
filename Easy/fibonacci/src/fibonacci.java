
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.System.exit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author richard
 */
public class fibonacci {
    private static final Logger LOG = getLogger(fibonacci.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new fibonacci().run(args[0]);
    }
    
    void run(String args) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(args));
            while (input.ready()) {
                System.out.println(fibo(parseInt(input.readLine())));
            }
        } catch (IOException ex) {
            getLogger(fibonacci.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }        
    }

    int fibo(int value) {
        int fn2 = 0;
        int fn1 = 1;
        int fn = 1;
        int fnOld;
        
        if (value == 0) {
            return 0;
        }
        
        for (int count = 1; count < value; count ++) {
            fn = fn2 +  fn1;
            if (fn < 0) {
                throw new RuntimeException("integer overflow");
            }
            fn2 = fn1;
            fn1 = fn;
        }
        return fn;
    }
}
