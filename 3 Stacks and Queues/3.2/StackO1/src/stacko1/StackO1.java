/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stacko1;

/**
 *
 * @author Rui
 */

public class StackO1{
    
    public static void main(String[] args) throws Exception{
        StackO1 stack = new StackO1();
        
        stack.printStack();
        
        stack.push(5);
        stack.printStack();
        
        stack.push(6);
        stack.printStack();
        
        stack.push(3);
        stack.printStack();        
        
        stack.push(7);
        stack.printStack();
        
        System.out.println("\nPop " + stack.pop() );
        stack.printStack();        
        
        System.out.println("\nPop " + stack.pop() );
        stack.printStack();
        
        System.out.println("\nPop " + stack.pop() );     
        stack.printStack();        
        
        System.out.println("\nPop " + stack.pop() );     
        stack.printStack();               
        
    }
    
    private Node top;
   
    public void push(int element){
        if( top  != null){
            Node tmp = new Node(element, top);
            top = tmp;
        }
        else
            top = new Node(element, null);    
    }
    
    public int pop() throws Exception{
        if( top != null){
            int element = top.data;
            top = top.next;
            return element;
        }
        else
            throw new Exception("Stack is empty to pop out.");
    }
    
    public int getMin() throws Exception{
        if( top != null)
            return top.currentMin;
        else
            throw new Exception("Stack has no element.");
    }
    
    public void printStack() {
        Node n = top;  
        
        System.out.println("\nStack:");
        while( n != null){
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println("End.");        
        
        if (top != null)
            System.out.println("Min is " + top.currentMin);                
        else
            System.out.println("no Min. \n");                   
    }   
    
    
    
    
}
