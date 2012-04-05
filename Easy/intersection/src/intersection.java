import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class intersection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(args[0]));
            final List<String> list1 = new ArrayList<String>();
            final List<String> list2 = new ArrayList<String>();
            final List<String> intersection = new ArrayList<String>(); 
            while (input.ready()) {
                final String[] lists = input.readLine().split(";");
                list1.clear();
                list2.clear();
                intersection.clear();
                list1.addAll(Arrays.asList(lists[0].split(",")));
                list2.addAll(Arrays.asList(lists[1].split(",")));
                for (String item : list1) {
                    if (list2.contains(item)) {
                        intersection.add(item);
                    }
                }
                final String output = intersection.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
                System.out.println(output);
            }
        } catch (IOException ex) {
            Logger.getLogger(intersection.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
}