/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mergeminton;

/**
 *
 * @author Rui
 */
public class MergeMIntoN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MergeMIntoN mmin = new MergeMIntoN();
        
        String mStr = "10011";        
        int m = Integer.parseInt( mStr, 2);
                
        String nStr = "10000000000";        
        int n = Integer.parseInt( nStr, 2);             
        
        int j = 6;
        int i = 2;
        
        System.out.println( "Expected number = 10001001100" ); 
        
        // Solu 1: merge m in one pass
        System.out.println( Integer.toBinaryString( mmin.merge(m, n, j, i) ) );  
        
        // Solu 2: update one bit each pass
        System.out.println( Integer.toBinaryString( mmin.merge2(m, n, j, i) ) );  
    }
    
    public int merge(int m, int n, int j, int i){
        
        // Method 1: works
        int mask = ~( ( 1<<(j+1) )-1  )  |  (  ( 1<<i )-1  );
        
        System.out.println("mask_10 = "+ mask);
        System.out.println("mask_2 = " + Integer.toBinaryString(mask));
        
//        // Method 2: works
//        int allOnes = ~0;
//        //                 bitwise right shift                  // left shift
//        int mask = ( allOnes >>> ( 31 - (i - 1)) )   |   ( allOnes << ( (j + 1) - 0 ) ) ;
        
        
        int mShift = m << i;
        
        int nMasked = n & mask;
        
        return nMasked | mShift;    
    }
    
    
    
    public int merge2(int m, int n, int j, int i){
        int nNew = n;  
        for( int k = 0; k <= j-i; k++){
            int v = getBit(m, k);
            nNew = updateBit(nNew, v, i+k);
        }
        
        return nNew;
    }
    
    public int getBit(int n, int i){
        if(  (n & (1<<i)) != 0 )
            return 1;
        else 
            return 0;               
    }
    
    public int updateBit(int n, int v, int i){
        return (n & ( ~(1 << i) )) | (v << i);    
    }
    
}
