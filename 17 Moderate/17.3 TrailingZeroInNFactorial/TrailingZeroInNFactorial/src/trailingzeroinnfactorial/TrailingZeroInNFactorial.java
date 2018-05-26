/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trailingzeroinnfactorial;

/**
 *
 * @author Rui
 */
public class TrailingZeroInNFactorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int n = 26;
        
        TrailingZeroInNFactorial t = new TrailingZeroInNFactorial();

        // Solu 2.1:
        System.out.println( t.getZeros21(n) );        
        
        // Solu 1: factorial may overflow
        System.out.println( t.getZeros(n) );

    }
    
    // Solu 2.1:
    public int getZeros21(int n){
        if( n <= 0 )
            return -1;
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            count += numOf5( i );
        }
        return count;        
    }
    
    public int numOf5(int i){
        
        //can improve by using dynamic programming to cache known results
        
        int count = 0;
        while( i % 5 == 0){
            count++;
            i = i / 5;
        }
        return count;
    }
       
    
    
    // Solu 1: factorial may overflow
    public int getZeros(int n){
        if( n <= 0)
            return -1;
        
        int fac = factorial( n);
        System.out.println( fac );
        
        int count = countZeros( fac );
        return count;
    }
    
    public int factorial( int n){
        if( n == 1)
            return 1;
        
        return n * factorial( n - 1);
    }
    
    public int countZeros( int num){
        int count = 0;
        
        while(true){
            if( num % 10 == 0){
                count++;
                num = num / 10;
            }
            else
                break;
                
        }
        return count;
    }
   
}
