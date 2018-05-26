/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmethod;

/**
 *
 * @author Rui
 */
public class MaxMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a = -3; 
        int b = -5;               
        
        MaxMethod mm = new MaxMethod();

        // Solu 2:
        System.out.println( mm.getMax(a, b) );        
        
        // Solu 1:
        System.out.println( mm.max(a, b) );
    }
    
    // Solu 2: better. can not use if-else
    public int getMax(int a, int b){
//        if( getSign(a) == getSign(b) ){
//            int q = getSign(a-b);
//            int p =  1 - q;
//            return p * a + q * b;
//        }
//        else{
//            if( getSign(a) == 0 )
//                return a;
//            else
//                return b;
//        }
        
        int q = getSign(a-b);
        int p = 1 - q;
                // a and b same sign                             // a and b different sign
        return ( 1 - getSign(a)^getSign(b) ) * ( p * a + q * b )  +  (getSign(a)^getSign(b)) * ( (1-getSign(a))*a + (1-getSign(b))*b );
               
    }
    
    public int getSign(int n){
        return  (n >> 31) & 0x01;
    }
    
    
    // Solu 1:
    public int max(int a, int b){       
        return sameSign(a,b) *( sign(a - b)*a + (1-sign(a - b))*b ) + (1-sameSign(a,b) )*( sign(a)*a + (1-sign(a))*b );
    }       
    
    public int sign(int num){                
        //System.out.println( Integer.toBinaryString(num >> 31 ) );
        //System.out.println( Integer.toBinaryString(num >>> 31 ) );
        
        return (num >>> 31) ^ 0x01;
    }
    
    public int sameSign(int a, int b){
        return (a >>> 31) ^ (b >>> 31) ^ 0x01;    
    }
}
