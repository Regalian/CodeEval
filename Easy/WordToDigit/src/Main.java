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
                String[] numbers = input.readLine().trim().split("\\;");
                for (String number: numbers) {
                    switch(number) {
                        case "zero": System.out.print("0"); break;
                        case "one": System.out.print("1"); break;
                        case "two": System.out.print("2"); break;
                        case "three": System.out.print("3"); break;
                        case "four": System.out.print("4"); break;
                        case "five": System.out.print("5"); break;
                        case "six": System.out.print("6"); break;
                        case "seven": System.out.print("7"); break;
                        case "eight": System.out.print("8"); break;
                        case "nine": System.out.print("9"); break;
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
