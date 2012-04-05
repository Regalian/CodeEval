
import java.io.BufferedReader;
import java.io.File;
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
public class number_pairs {

    public number_pairs() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new number_pairs().run(args[0]);
    }

    public void run(final String filename) {
        File file = new File(filename);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            List<Pair> pairs = new ArrayList<Pair>();
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split(";");
                if (lineArray.length > 0) {
                    int target = Integer.parseInt(lineArray[1]);
                    String[] nums = lineArray[0].split(",");
                    int[] numbers = new int[nums.length];
                    for (int index = 0; index < nums.length; index++) {
                        numbers[index] = Integer.parseInt(nums[index]);
                    }
                    pairs.clear();
                    for (int first = 0; first < numbers.length - 1; first++) {
                        for (int second = first + 1; second < numbers.length; second++) {
                            if ((numbers[first] + numbers[second]) == target) {
                                pairs.add(new Pair(numbers[first], numbers[second]));
                            }
                        }
                    }
                }
                if (pairs.size() > 0) {
                    System.out.print(pairs.get(0));
                    for (int index = 1; index < pairs.size(); index++) {
                        System.out.print(';');
                        System.out.print(pairs.get(index));
                    }
                    System.out.println();
                } else {
                    System.out.println("NULL");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(number_pairs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private class Pair {
        private int first;
        private int second;
        
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        
        @Override
        public String toString() {
            StringBuilder output = new StringBuilder(Integer.toString(first));
            output.append(',').append(Integer.toString(second));
            return output.toString();
        }
    }
}
