/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stacko1;

/**
 *
 * @author Rui
 */

public class Node{

    public int data;
    public Node next;
    public int currentMin;
    
    public Node(int d, Node n){
        data = d;
        next = n;
        
        if( n != null)        
            currentMin = Math.min(data, next.currentMin);
        else
            currentMin = data;
    }
}