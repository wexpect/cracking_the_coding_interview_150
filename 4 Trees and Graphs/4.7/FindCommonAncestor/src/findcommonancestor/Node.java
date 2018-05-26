/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findcommonancestor;

public class Node{

    public Comparable data;
    public Node left;
    public Node right;
    public Node parent;
    
    public Node(Comparable obj){
        data = obj;
    }

}
