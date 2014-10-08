import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;
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
public class intersection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final BufferedReader input = new BufferedReader(new FileReader(args[0]));
            final List<String> list1 = new ArrayList<>();
            final List<String> list2 = new ArrayList<>();
            final List<String> intersection = new ArrayList<>(); 
            while (input.ready()) {
                final String[] lists = input.readLine().split(";");
                list1.clear();
                list2.clear();
                intersection.clear();
                list1.addAll(asList(lists[0].split(",")));
                list2.addAll(asList(lists[1].split(",")));
                for (String item : list1) {
                    if (list2.contains(item)) {
                        intersection.add(item);
                    }
                }
                final String output = intersection.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "");
                System.out.println(output);
            }
        } catch (IOException ex) {
            getLogger(intersection.class.getName()).log(Level.SEVERE, null, ex);
            exit(1);
        }
    }
}