/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

/**
 *
 * @author Rui
 */
public class Node<T> {
    public T data;
    public Node<T> next;
    
    public Node(T d){
        data = d;
    }        
}
