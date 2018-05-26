/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package count2s;

import java.util.HashMap;

/**
 *
 * @author Rui
 */
public class Count2s {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Count2s c2 = new Count2s();
        
        int n = 25;
        
        System.out.println("Solu 1" );
        System.out.println( c2.countRange(n) );
        
        
        System.out.println("\nSolu 2" );
        System.out.println( c2.countRange2(n) );        
    }
    
    // Solu 1
    public int countRange(int n){
        if( n < 0 )
            return 0;
        
        int count = 0;
        for(int i = 0; i <= n; i++){
            count += countNum(i);
        }
        
        return count;
    }
    
    public int countNum(int n){
        if( n == 0 )
            return 0;
        
        int count = 0;
        int residue = 0;
        
        while( n != 0){
            residue = n % 10;            
            if( residue == 2)
                count++;
            n = n / 10;
        }
        return count;
    }
    
    //Solu 2:
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    
    public int countRange2(int n){
        if( n <= 0)
            return 0;
        
        return countRange2(n-1) + countNum2(n);
    }
    
    public int countNum2(int n){
        if( n == 0 )
            return 0;
        
        if( hm.containsKey(n) ){
            System.out.println("use hashMap: n = " + n);
            return hm.get(n) ;                    
        }
        else{
            int residue = n % 10;
            int divident = n / 10;
            int count = 0;
            
            if( residue == 2)
                count++;
            
            count += countNum2( divident );
            
            hm.put(n, count);
            System.out.println("add to hashMap: n = " + n);
            
            return count;
        }
    
    }
   
}
