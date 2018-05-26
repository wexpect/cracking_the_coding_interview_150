/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computeintegerrank;

public class TreeNode{

    public Comparable data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    
    public int count;
    
    public TreeNode(Comparable obj){
        data = obj;
        
        left = null;
        right = null;
        parent = null;
        
        count = 1;
    }

}
