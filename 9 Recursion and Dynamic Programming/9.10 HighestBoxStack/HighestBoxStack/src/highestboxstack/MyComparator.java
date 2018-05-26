/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package highestboxstack;

import java.util.Comparator;

/**
 *
 * @author Rui
 */
public class MyComparator implements Comparator<Box> {
    
    // sort from high to low
    public int compare(Box b1, Box b2){
            if( - b1.height >  - b2.height)                    
                return 1;
            else if( - b1.height == - b2.height)                   
                return 0;
            else                    
                return -1;    
    }

}
