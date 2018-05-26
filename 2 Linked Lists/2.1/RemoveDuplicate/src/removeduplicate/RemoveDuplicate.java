/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package removeduplicate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Rui
 */

public class RemoveDuplicate{
    
    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.addFirst("a");
        linkedList.addFirst("1");        
        linkedList.addFirst("cbb");        
        linkedList.addFirst("2");
        linkedList.addFirst("cbb");                
        linkedList.addFirst("3");
        linkedList.addFirst("cbb");                
        linkedList.addFirst("4");
        linkedList.addFirst("cbb");         
        
        for(String element : linkedList){
            System.out.print(element + " ");
        }        
        System.out.println();
        
        
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        removeDuplicate.removeDuplicate(linkedList);
        
/*        
        // Solu 2
        RemoveDuplicate removeDuplicate2 = new RemoveDuplicate();
        removeDuplicate2.removeDuplicateInPlace(linkedList);
*/
        
        for(String element : linkedList){
            System.out.print(element + " ");
        }        
    }
    
    
    public void removeDuplicate(LinkedList<String> linkedList){
        
        HashSet<String> hashSet = new HashSet<String>();
        
        ListIterator<String> listIterator = linkedList.listIterator();
        
        while( listIterator.hasNext() ){
            String element = listIterator.next();
            System.out.print("check: " + element);
            
            if( hashSet.contains(element) ){
                System.out.println(", is duplicate, remove");                
                listIterator.remove();
            }
            else{
                System.out.println(", not duplicate, add");                
                hashSet.add(element);
            }            
        }
                
    }
    
    
/*    
    // Solu 2: this does not work because using remove() when having multiple iterators cause concurrent modifications
    public void removeDuplicateInPlace(LinkedList<String> linkedList){
                
        ListIterator<String> listIterator1 = linkedList.listIterator();
        
                
        String currentElement;
        int count1 = 0;
        
        while( listIterator1.hasNext() ){
            currentElement = listIterator1.next();


            ListIterator<String> listIterator2 = linkedList.listIterator();                                
            int count2 = 0;
            String compareElement;
            while( listIterator2.hasNext() ){                
                compareElement = listIterator2.next();
                
                if( count2 > count1){
                    if( compareElement.equals(currentElement) ){
                        listIterator2.remove();
                    }
                }
                
                ++ count2;
            }

            ++ count1;
        }
        
    }
*/            
    
    
}

