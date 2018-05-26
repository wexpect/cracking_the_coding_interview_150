/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphiosophers;

/**
 *
 * @author Rui
 */
public class DiningPhiosophers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numPeople = 5;
        int numFood = 15;
        
        Table table = new Table(numPeople, numFood);
        People[] p = new People[numPeople];
        for(int i = 0; i < numPeople; i++){
            p[i] = new People(i, table);
        }
        
        Thread[] t = new Thread[numPeople];
        for(int i = 0; i < numPeople; i++){
            t[i] = new Thread(p[i]);
        }        
        
        for(int i = 0; i < numPeople; i++){
            t[i].start();
        }                
    }
}
