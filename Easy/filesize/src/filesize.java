/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;

/**
 *
 * @author richard
 */
public class filesize {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File(args[0]);
        System.out.println(file.length());
    }
}
