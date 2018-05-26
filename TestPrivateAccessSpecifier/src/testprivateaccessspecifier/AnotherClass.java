/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testprivateaccessspecifier;

/**
 *
 * @author Rui
 */
public class AnotherClass {
 private int data = 1;
    
    /**
     * @param args the command line arguments
     */

    public void add(AnotherClass m){
        int sum = data + m.data;        
    }
    
}
