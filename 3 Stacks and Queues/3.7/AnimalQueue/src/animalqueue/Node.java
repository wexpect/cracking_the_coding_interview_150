/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animalqueue;

/**
 *
 * @author Rui
 */
public class Node {
 
    public Animal data;
    public Node next;

    public int time;    
    
    public Node(Animal a, int t){
        data = a;
        time = t;
    }
}
