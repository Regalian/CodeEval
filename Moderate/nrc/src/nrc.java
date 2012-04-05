
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
public class nrc {

    private BufferedReader input;

    public nrc(String inputFilename) throws FileNotFoundException {
        input = new BufferedReader(new FileReader(inputFilename));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        new nrc(args[0]).run();
    }

    void run() {
        try {
            while (input.ready()) {
                final String inputLine = input.readLine();
                if (inputLine.length() > 0) {
                    final char[] chars = inputLine.toCharArray();
                    Map<Character, CharacterDetails> characters =  new HashMap<Character, CharacterDetails>();
                    int index = 0;
                    for (char character: chars) {
                        Character c = new Character(character);
                        if (characters.containsKey(c)) {
                            characters.get(c).increment();
                        } else {
                            characters.put(c, new CharacterDetails(c, index));
                        }
                        index++;
                    }
                    List<CharacterDetails> nonRepeating = new ArrayList<CharacterDetails>();
                    for (CharacterDetails cd: characters.values()) {
                        if (cd.count == 1) {
                            nonRepeating.add(cd);
                        }
                    }
                    Collections.sort(nonRepeating, new Comparator<CharacterDetails>() {

                        @Override
                        public int compare(CharacterDetails t, CharacterDetails t1) {
                            return t.position - t1.position;
                        }
                    });
                    System.out.println(nonRepeating.get(0).character);
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(nrc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private class CharacterDetails {
        private Character character;
        private int position;
        private int count;
        
        CharacterDetails(final Character character, final int position) {
            this.character = character;
            this.position = position;
            count = 1;
        }
        
        public void increment() {
            count++;
        }
        
        @Override
        public String toString() {
            return "character: " +  character.toString() + " count: " + count + " position: " + position;
        }
        
        public int getPosition() {
            return position;
        }
        
        public Character getCharacter() {
            return character;
        }
    }
}
