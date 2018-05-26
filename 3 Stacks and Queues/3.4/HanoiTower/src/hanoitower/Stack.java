/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoitower;

/**
 *
 * @author Rui
 */

public class Stack{

    private Node top;
    public String position;
    
    public Stack(String p){
        position = p;
    }
    
    public void push(int d){
        Node n = new Node(d);
        n.next = top;
        top = n;
    }
    
    public int pop() throws Exception{
        if( top != null ){
            int element = top.data;
            top = top.next;
            return element;
        }
        else
            throw new Exception("Stack is empty");
    }
    
    public void printStack(){
        System.out.println("\nStack " + position +":");
        
        Node n = top;
        while( n != null){
            System.out.println(n.data);
            n = n.next;
        }            
    }
    
}