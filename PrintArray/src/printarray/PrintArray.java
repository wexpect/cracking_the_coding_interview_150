/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package printarray;

import java.util.Arrays;

/**
 *
 * @author Rui
 */
public class PrintArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] im = {1,2,3,4};
        System.out.println(im);        
        System.out.println(im.toString() );
        System.out.println(Arrays.toString(im));  // use this to print out int array
        
        char[] cm = {'a','b','c'};
        System.out.println(cm);    // use this to print out char array                    
        System.out.println(cm.toString() );        
        System.out.println(Arrays.toString(cm));             
    }
}
