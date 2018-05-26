/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplysubtractdivide;

/**
 *
 * @author Rui
 */
public class MultiplysubtractDivide{

    public static void main(String[] args) throws Exception {
        MultiplysubtractDivide msd = new MultiplysubtractDivide();
        
        int a = -5;        
        int b = -2;
    
        System.out.println(" a + b = " + msd.subtract(a, b) );
        System.out.println(" a * b = " + msd.multiply(a, b) );
        
        System.out.println(" a / b = " + msd.divide(a, b) );
        System.out.println("Expected a / b = " + a / b );
        System.out.println("Expected a % b = " + a % b );
        
    }
    
    public int neg(int n){
        
        int r = 0;
        
        if( n > 0 ){
            for(int i = 1; i <= n; i++){
                r += -1;
            }            
        }
        else if( n < 0 ){
            for( int i = -1; i >= n; i-- ){
                r += 1;
            }
        }
        
        return r;    
    }
    
    public int subtract(int a, int b){
        return a + neg( b );
    }
    
    public int multiply(int a, int b){
        int r = 0;
        
        if( b > 0 ){
            for( int i = 1; i <= b; i++){
                r += a;
            }
            
        }
        else if( b < 0 ){
            for( int i = -1; i >= b; i--){
                r += a;
            }
            
            r = neg( r );
        }
        
        return r;
    }
    
    public int divide(int a, int b) throws Exception{
    
        if( b == 0){
            throw new Exception(" b can not be 0!");
        }
    
        if( a == 0){
            return 0;
        }
        
        int absa = abs(a);
        int absb = abs(b);
        
        int sum = 0;
        int absc = 0;
        
        while( sum <= absa){
            sum += absb;
            absc++;
        }
        absc--;
        
        if( (a > 0 && b < 0) || (a <0 && b >0) ){
            return neg(absc);
        }
        else{
            return absc;
        }
    }
    
    public int abs(int n){
        if( n >= 0)
            return n;
        else
            return neg(n);
    }
    
}
