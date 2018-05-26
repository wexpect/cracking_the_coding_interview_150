/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multiqueuewitharray;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rui
 */

public class MultiQueueWithArray{
    
    public static void main(String[] args) throws Exception{

        MultiQueueWithArray mq = new MultiQueueWithArray(10);
    
        mq.printQueue();
        
        System.out.println(mq.isEmpty(1));
            
        mq.push(1, 0);        
        mq.push(10, 1);
        mq.push(100, 2);       
        mq.printQueue();               
        System.out.println("top = " + mq.top[0] + " "+ mq.top[1]+ " " + mq.top[2]);
               
        mq.push("ab", 0);        
        mq.push("cd", 1);
        mq.push("ef", 2);                    
        mq.printQueue();
        System.out.println("top = " + mq.top[0] + " "+ mq.top[1]+ " " + mq.top[2]);
        
        mq.push(3.2, 0);        
        mq.push(30.3, 1);
        mq.push(300.5, 2);               
        mq.printQueue();        
        System.out.println("top = " + mq.top[0] + " "+ mq.top[1]+ " " + mq.top[2]);
        
        mq.pop(0);        
        mq.pop(1);
        mq.pop(2);        
        mq.printQueue();        
        System.out.println("top = " + mq.top[0] + " "+ mq.top[1]+ " " + mq.top[2]);
        
        mq.push('A', 0);        
        mq.push('B', 1);
        mq.push('C', 2);        
        mq.printQueue();         
        System.out.println("top = " + mq.top[0] + " "+ mq.top[1]+ " " + mq.top[2]);
        
        // The following push causes Exception
        //mq.push(5, 0);        
   
    }
    
   
    private Object[] array;   
    private int[] bottom = new int[3];   
    private int[] top = new int[3];   
    private int[] topMax = new int[3];         
   
    public MultiQueueWithArray(int n){
       array = new Object[n];
       
       bottom[0] = -1;
       top[0] = -1;
       topMax[0] = n/3; //same as   = (int) Math.floor(n/3)

       bottom[1] = n/3;
       top[1] = n/3;
       topMax[1] = 2 * n/3;       

       bottom[2] = 2 * n/3;
       top[2] = 2 * n/3;     
       topMax[2] = n-1;          
       
       System.out.println("top = " + top[0] + " "+ top[1]+ " " + top[2]);
       System.out.println("topMax = " + topMax[0] + " "+ topMax[1]+ " " + topMax[2]);       
    }
    
    public void push(Object element, int k) throws Exception{
        System.out.println("Before push to Queue "+ k +". Top = "+ top[k]);
        
        if( top[k] >= topMax[k] ){
            throw new Exception("Queue " + k + " is full." + top[k] + " " + topMax[k] );
        }
        else{
            top[k]++;                
            array[ top[k] ] = element;
        }
        
        System.out.println("After push to Queue "+ k +". Top = "+ top[k]);        
    }
    
    public Object pop(int k) throws Exception{
        System.out.println("Before pop from Queue "+ k +". Top = "+ top[k]);
        
        if( top[k] == bottom[k] ){
            System.out.println("After pop from Queue "+ k +". Top = "+ top[k]);               
            throw new Exception("Queue " + k + " is empty.");
        }
        else{
            Object tmpElement = array[ top[k] ];
            top[k]--;
            System.out.println("After pop from Queue "+ k +". Top = "+ top[k]);               
            return tmpElement;
        }             
    }
   
    public boolean isEmpty(int k){
        return bottom[k] == top[k];
    }
    
    public void printQueue( ){
       for(int k = 0; k < 3; k++){
           for(int i = bottom[k]+1; i <= top[k]; i++){
               System.out.print(array[i] + " ");
           }
           System.out.println();
       }                         
       System.out.println("\n");
    }

}


