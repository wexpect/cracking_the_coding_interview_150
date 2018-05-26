/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testplusplus;

/**
 *
 * @author Rui
 */
public class TestPlusPlus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        

        int x = 5, y = 5;

        System.out.println(++x); // outputs 6
        System.out.println(x); // outputs 6

        int c = y++;
        System.out.println(c); // outputs 6        
        //System.out.println(y++); // outputs 5
        System.out.println(y); // outputs 6



        
        int m = 21;
         int p = m++;
        System.out.println( "m = " + m ); 
        System.out.println( "m = " + m++ );          
         System.out.println( "p = " + p );          
         
         int q = ++p;
        System.out.println( "p = " + p ); 
        System.out.println( "q = " + q );        
    }
}
