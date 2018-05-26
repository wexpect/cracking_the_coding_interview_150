/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package computeintegerrank;

/**
 *
 * @author Rui
 */
public class ComputeIntegerRank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       BinarySearchTree BST = new BinarySearchTree();
        
        //int[] keyArray = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,15};
       int[] keyArray = {5,1,4,4,5,9,7,13,3};
        for(int key : keyArray){
            BST.track( key ); 
            BST.inOrderTraverse(BST.root);
            System.out.println();
        }                    

        System.out.println( "Rank: "+BST.getRankOfNum(1));                
        System.out.println( "Rank: "+BST.getRankOfNum(3));
        System.out.println( "Rank: "+BST.getRankOfNum(4));                
        System.out.println( "Rank: "+BST.getRankOfNum(5));
        System.out.println( "Rank: "+BST.getRankOfNum(7));                
        System.out.println( "Rank: "+BST.getRankOfNum(9));
        System.out.println( "Rank: "+BST.getRankOfNum(13));                
        
        System.out.println( "Rank: "+BST.getRankOfNum(6));                        

    }
}
