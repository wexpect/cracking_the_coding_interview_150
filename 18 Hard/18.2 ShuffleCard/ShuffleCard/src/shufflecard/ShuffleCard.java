/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shufflecard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Rui
 */
public class ShuffleCard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        ShuffleCard sc = new ShuffleCard();
        
        int[] oldDeck = new int[52];
        for(int i = 0; i < 52; i++){
            oldDeck[i] = i;
            System.out.print( oldDeck[i] + " ");
        }
        
        System.out.println();
        
        int[] newDeck = sc.shuffle(oldDeck);
        for(int i = 0; i < 52; i++){
            System.out.print( newDeck[i] + " ");
        }        

        System.out.println();
        
        sc.shuffle2(oldDeck);
        for(int i = 0; i < 52; i++){
            System.out.print( oldDeck[i] + " ");
        }                
    }
    
    // Solu 1:
    public int[] shuffle(int[] old){
        if( old == null || old.length != 52)
            return null;
            
        LinkedList<Integer> oldList = getList(old);
        
        int[] newDeck = new int[52];
        
        Random rand = new Random();
        
        for(int i = 51; i >= 0; i--){
            int k = rand.nextInt(i+1);   // [0, i+1)
            int card = oldList.get(k);
            oldList.remove(k);
            newDeck[i] = card;
        }
        
        return newDeck;
            
    }

    public LinkedList<Integer> getList(int[] arr){
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i : arr){        
            list.add(i);
        }            
        
        return list;
    }

    
    // Solu 2:
    public void shuffle2(int[] arr){
        Random rand = new Random();
        
        for(int i = 51; i >= 0; i--){
            int k = rand.nextInt(i+1);
            
            int tmp = arr[k];
            arr[k] = arr[i];
            arr[i] = tmp;
        }
    }
   
}
