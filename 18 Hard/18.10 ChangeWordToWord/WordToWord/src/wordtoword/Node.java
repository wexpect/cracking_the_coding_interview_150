/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wordtoword;

/**
 *
 * @author Rui
 */

public class Node{
    public String data;
    public String options;
    
    public Node predecessor;

    public Node next;
    
    public Node(String d){
        data = d;
        options = null;
        predecessor = null;
    }
}