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
public class CircularArray <T> implements Iterable <T>{
    private int iH;
    public int n;
    private T[] arr;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int n = 10;
        
        CircularArray<Integer> ca = new CircularArray<Integer>(n);
        //CircularArray ca = new CircularArray(n); 
  
        System.out.println( ca.get(0) );
        
        ca.set(0, 0);
        System.out.println( ca.get(0) );
        
        ca.set(1, 1);
        System.out.println( ca.get(1) );
        
        ca.set(2, 2);
        System.out.println( ca.get(2) );
        
        ca.rotate();
        System.out.println( ca.get(0) );
        
        
        for(Integer i : ca){
            System.out.print(i + " ");
        }
    }
    
    public CircularArray (int nn) throws Exception{
        if( nn <= 0 )
            throw new Exception("error");
        
        iH = 0;
        n = nn;
        arr = (T[]) new Object[n];
    }
    
    public void rotate(){
        iH = ( iH + 1 ) % n;
    }
    
    public int convert(int j){
        while( j < 0 ){
            j += n;
        }
        
        return ( iH + j ) % n;
    }
    
    public void set(int j, T obj) throws Exception{        
        int i = convert(j);
        arr[i] = obj;
    }
    
    public T get(int j){             
        int i = convert(j);
        return arr[i];
    }
    
    
    public Iterator<T> iterator(){
        return new CAIterator<T>(this);
    }
}
