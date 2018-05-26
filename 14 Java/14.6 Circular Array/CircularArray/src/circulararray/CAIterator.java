/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package circulararray;

import java.util.Iterator;

/**
 *
 * @author Rui
 */
public class CAIterator<T> implements Iterator<T>{
    private int k;
    private CircularArray<T> carr;
    
    public CAIterator(CircularArray<T> carrIn){
        k = -1;  // not k = 0;
        carr = carrIn;
    }
    
    public boolean hasNext(){
        return ( k + 1) <= (carr.n - 1); 
    }
    
    public T next(){
        k++;
        return carr.get(k);
    }
    
    public void remove(){
        return;
    }
}
