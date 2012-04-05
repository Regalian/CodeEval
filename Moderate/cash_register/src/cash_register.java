
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
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
public class cash_register {

    private BufferedReader input;

    public cash_register(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new cash_register(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final String[] values = input.readLine().split(";");
                final BigDecimal purchasePrice = new BigDecimal(values[0]);
                final BigDecimal cash = new BigDecimal(values[1]);
                final BigDecimal change = cash.subtract(purchasePrice);
                if (purchasePrice.equals(cash)) {
                    System.out.println("ZERO");
                } else if (cash.compareTo(purchasePrice) < 0) {
                    System.out.println("ERROR");
                } else {
                    final List<Change> changeList = calculateChange(change);
                    Collections.sort(changeList, new Comparator<Change>() {

                        public int compare(Change o1, Change o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    });
                    final String output = formatChangeList(changeList);
                    System.out.println(output);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(cash_register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<Change> calculateChange(BigDecimal change) {
        List<Change> changeList = new ArrayList<Change>();
        Change[] possibleValues = Change.values();
        Arrays.sort(possibleValues, new Comparator<Change>() {

            public int compare(Change o1, Change o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (Change value : possibleValues) {
            while (change.compareTo(value.getValue()) >= 0) {
                changeList.add(value);
                change = change.subtract(value.getValue());
            }
        }
        return changeList;
    }

    private String formatChangeList(List<Change> changeList) {
        StringBuilder output = new StringBuilder();
        output.append(changeList.get(0));
        for (int index = 1; index < changeList.size(); index++) {
            output.append(",").append(changeList.get(index));
        }
        return output.toString();
    }

    private enum Change {

        PENNY("PENNY", ".01"), NICKEL("NICKEL", ".05"), DIME("DIME", ".10"),
        QUARTER("QUARTER", ".25"), HALF_DOLLAR("HALF DOLLAR", ".50"),
        ONE("ONE", "1.00"), TWO("TWO", "2.00"), FIVE("FIVE", "5.00"),
        TEN("TEN", "10.00"), TWENTY("TWENTY", "20.00"), FIFTY("FIFTY", "50.00"),
        ONE_HUNDRED("ONE HUNDRED", "100.00");
        private String name;
        private BigDecimal value;

        Change(String name, String value) {
            this.name = name;
            this.value = new BigDecimal(value);
        }

        public String getName() {
            return name;
        }

        public BigDecimal getValue() {
            return value;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
