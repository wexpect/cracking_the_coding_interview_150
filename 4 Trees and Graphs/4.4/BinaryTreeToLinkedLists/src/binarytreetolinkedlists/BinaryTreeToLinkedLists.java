/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytreetolinkedlists;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Rui
 */
public class BinaryTreeToLinkedLists {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree BST = new BinarySearchTree();
        
        int[] keyArray = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15,16,17};
        for(int key : keyArray){
            BST.insert(BST.root, new NodeData(key)); 
            BST.inOrderTraverse(BST.root);
            System.out.println();
        }               
        
        
        ArrayList<LinkedList<Node>> arrayList = new ArrayList<LinkedList<Node>>();
        int depth = 0;
        
        BinaryTreeToLinkedLists BTtoLists = new BinaryTreeToLinkedLists();
        BTtoLists.addToList(BST.root, depth, arrayList);        
        
        for(LinkedList<Node> levelList : arrayList){
            System.out.println();
            for(Node n : levelList){
                System.out.print(  ((NodeData)n.data).getKey() +" " ); 
            }
        }        
    }
    
    public void addToList(Node n, int depth, ArrayList<LinkedList<Node>> arrayList){
        if( n == null)
            return;
        
        if( arrayList.size() - 1 < depth){
            LinkedList<Node> levelList = new LinkedList<Node>();
            levelList.addFirst(n);
            arrayList.add(levelList);
        }
        else
            arrayList.get(depth).addFirst(n);
            
        addToList(n.left, depth + 1, arrayList);
        addToList(n.right, depth + 1, arrayList);        
    }
    
    
}
