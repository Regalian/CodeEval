
import java.nio.ByteOrder;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

/**
 *
 * @author richard
 */
public class endian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        System.out.println((byteOrder == ByteOrder.BIG_ENDIAN) ? "BigEndian" : "LittleEndian");
    }
}
