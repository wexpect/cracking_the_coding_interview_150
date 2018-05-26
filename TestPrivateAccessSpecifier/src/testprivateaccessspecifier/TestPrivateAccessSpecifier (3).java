/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testprivateaccessspecifier;

/**
 *
 * @author Rui
 */
public class TestPrivateAccessSpecifier {

    private int data = 1;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        TestPrivateAccessSpecifier t = new TestPrivateAccessSpecifier();
        
        t.data = 1;
        
        AnotherClass ac = new AnotherClass();
        ac.data = 2;
        
    }
    
    public void add(TestPrivateAccessSpecifier m){
        int sum = data + m.data;        
    }

    public void addOther(AnotherClass m){
        int sum = data + m.data;        
    }    
    
}
