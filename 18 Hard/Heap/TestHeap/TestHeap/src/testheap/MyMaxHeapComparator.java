/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testheap;

import java.util.Comparator;

/**
 *
 * @author Rui
 */
public class MyMaxHeapComparator implements Comparator<Double>{
    public int compare(Double d1, Double d2){
        if( d1 > d2)
            return -1;
        else if( d1 == d2)
            return 0;
        else
            return 1;
    }
}
