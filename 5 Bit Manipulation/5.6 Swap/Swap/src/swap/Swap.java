/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swap;

/**
 *
 * @author Rui
 */
public class Swap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num = 0b01010101010101010101010101011001;
        System.out.println(num);
        System.out.println(Integer.toBinaryString(num).length());
        
        Swap s = new Swap();
        int new_num = s.swap(num);
        
        System.out.println(Integer.toBinaryString(new_num));
        System.out.println(Integer.toBinaryString(new_num).length());
    }
    
    public int swap( int num){
        int odd_mask = 0xaaaaaaaa;   // 32-bit  1010 ... 1010
        int even_mask = 0x55555555;  // 32-bit  0101 ... 0101
        
        int odd = num & odd_mask;
        int even = num & even_mask;
        
        int new_even = odd >>> 1;
        int new_odd = even << 1;
        
        int new_num = new_even | new_odd;
        
        return new_num;
    }
}
