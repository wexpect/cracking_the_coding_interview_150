/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findkthsmallestnum;

import java.util.Comparator;

/**
 *
 * @author Rui
 */
public class MyMaxHeapComparator implements Comparator<Integer>{
    public int compare(Integer n1, Integer n2){
        if( n1 < n2)
            return 1;
        else if( n1 == n2)
            return 0;
        else
            return -1;
    }
}
