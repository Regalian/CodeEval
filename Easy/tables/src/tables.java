/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author richard
 */
public class tables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int x = 1; x < 13; x++){
            for (int y = 1; y < 13; y++) {
                System.out.printf("%4d", x * y);
            }
            System.out.println();
        }
    }
}
