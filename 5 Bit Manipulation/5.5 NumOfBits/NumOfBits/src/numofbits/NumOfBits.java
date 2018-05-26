/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numofbits;

/**
 *
 * @author Rui
 */
public class NumOfBits {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int A = 2;
        int B = 9;
        
        NumOfBits nb = new NumOfBits();
        System.out.println( nb.getNum(A, B) );
                
    }
    
    public int getNum( int A, int B){
        int C = A ^ B;
                 
        System.out.println("C_10 = "+C);
        System.out.println("C_2 = "+Integer.toBinaryString(C));
        System.out.println(Integer.toBinaryString(C).length());

                
        int count = 0;
        
        while( C != 0 ){
            if( (C & 1) == 1 ) 
                count++;                                
            
            C = C >> 1;
            System.out.println("C_2 = "+Integer.toBinaryString(C));
        }
        
        return count;        
    }
}
