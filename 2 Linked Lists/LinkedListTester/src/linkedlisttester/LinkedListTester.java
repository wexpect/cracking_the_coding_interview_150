/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlisttester;

import java.util.LinkedList;
import java.util.ListIterator;


// Use Java Standard LinkedList

public class LinkedListTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<String> staff = new LinkedList<String>();

        staff.addLast("Dick");
        staff.addLast("Harry");        
        staff.addLast("Romeo");
        staff.addLast("Tom");        
        
        ListIterator<String> iterator = staff.listIterator();
        iterator.next();
        iterator.next();
        
        iterator.add("Juliet");
        iterator.add("Nina");
        
        iterator.next();
        
        iterator.remove();
        
        for(String name : staff)
        {
            //System.out.print(iterator.next() + " ");   // this line of code in the textbook is wrong
            System.out.print(name + " "); // should code like this line
        }
        
    }
}
