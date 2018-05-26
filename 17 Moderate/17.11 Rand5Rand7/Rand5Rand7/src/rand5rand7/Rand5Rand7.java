/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rand5rand7;

import java.util.Random;

/**
 *
 * @author Rui
 */
public class Rand5Rand7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for(int i = 0; i < 100; i++)
            System.out.print( Rand5Rand7.rand7() +" ");
    }
    
    public static int rand7(){
        while( true ){
            int value = 5 * rand5() + rand5();

            if( value <= 20 ){
                return value % 7;
            }
        }
    }
    
    public static int rand5(){
        Random rand = new Random();
        return rand.nextInt(5);
    }
}
