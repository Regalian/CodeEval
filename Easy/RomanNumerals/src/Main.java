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
                int number = Integer.parseInt(input.readLine().trim());
                while (number > 0) {
                    if (number >=1000) {
                        System.out.print("M");
                        number -= 1000;
                    } else if (number >= 900) {
                        System.out.print("CM");
                        number -= 900;
                    } else if (number >= 500) {
                        System.out.print("D");
                        number -= 500;
                    } else if (number >= 400) {
                        System.out.print("CD");
                        number -= 400;
                    } else if (number >= 100) {
                        System.out.print("C");
                        number -= 100;
                    } else if (number >= 90) {
                        System.out.print("XC");
                        number -= 90;
                    } else if (number >= 50) {
                        System.out.print("L");
                        number -= 50;
                    } else if (number >= 40) {
                        System.out.print("XL");
                        number -= 40;
                    } else if (number >= 10) {
                        System.out.print("X");
                        number -= 10;
                    } else if (number == 9) {
                        System.out.print("IX");
                        number -= 9;
                        break;
                    } else if (number >= 5) {
                        System.out.print("V");
                        number -= 5;
                    } else if (number == 4) {
                        System.out.print("IV");
                        number -= 4;
                        break;
                    } else {
                        System.out.print("I");
                        number--;
                    }
                }
                System.out.println();
            }
        } catch (IOException ex) {
            getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
    }

}
