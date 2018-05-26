/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setofstacks;

/**
 *
 * @author Rui
 */

public class Stack{
    private int size = 3;
    private Object[] sta = new Object[size];
    private int top = -1;
    
    public void push(Object element) throws Exception{
        if( isFull() ){
            throw new Exception("Stack is full.");            
        }
        
        top++;
        sta[top] = element;        
    }
    
    public Object pop() throws Exception{
        if( isEmpty() ){
            throw new Exception("Stack is empty");            
        }
        
        Object element = sta[top];
        top--;
        return element;
        
    }
    
    public boolean isFull(){
        return top == (size-1);
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public void printStack(){
        int tmp = top;
        
        while( tmp != -1){
            System.out.println( sta[tmp] );
            tmp--;
        }
        System.out.println("\n");
    }
    
}