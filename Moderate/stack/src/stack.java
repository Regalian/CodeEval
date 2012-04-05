
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
public class stack {

    private BufferedReader input;

    public stack(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new stack(args[0]).run();
    }

    void run() {
        try {
            final MyStack<Integer> stack = new MyStack<Integer>();
            while (input.ready()) {
                final String inputLine = input.readLine();
                if (inputLine.length() > 0) {
                    final String[] values = inputLine.split(" ");
                    stack.clear();
                    for (String value : values) {
                        stack.push(Integer.parseInt(value));
                    }

                    System.out.print(stack.pop());
                    int index = 1;
                    while (!stack.isEmpty()) {
                        Integer item = stack.pop();
                        if (index % 2 == 0) {
                            System.out.print(" " + item);
                        }
                        index++;
                    }
                    System.out.println();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(stack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class MyStack<T> {

        private List<T> stack;

        MyStack() {
            stack = new LinkedList<T>();
        }

        public void push(T item) {
            stack.add(0, item);
        }

        public T pop() {
            return stack.remove(0);
        }

        public void clear() {
            stack.clear();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }
}
