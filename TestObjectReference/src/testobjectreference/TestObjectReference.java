/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testobjectreference;



/**
 *
 * @author Rui
 */
public class TestObjectReference {

   public static void main(String[] args) {
        // TODO code application logic here
        IntWrapper intWrapper = new IntWrapper(0);
        System.out.println( intWrapper.key );        
        
        TestObjectReference tb = new TestObjectReference();
        tb.incKey1(intWrapper);

        System.out.println( intWrapper.key );                
    }
    
    public void incKey(IntWrapper intWrapper){    
                
        decKey(intWrapper);
        
        
        System.out.println("inc 1 "+intWrapper.key);
        
        intWrapper.key ++;
        
        System.out.println("inc  2 "+intWrapper.key);
        
        decKey(intWrapper);        
    }
    
    public void decKey(IntWrapper intWrapper){
        intWrapper = new IntWrapper(-20);
                
        //intWrapper.key --;
        System.out.println("dec "+intWrapper.key);
    }
    
   public void incKey1(IntWrapper intWrapper){    
                
        intWrapper = decKey1(intWrapper);
        
        
        System.out.println("inc 1 "+intWrapper.key);
        
        intWrapper.key ++;
        
        System.out.println("inc  2 "+intWrapper.key);
        
        //intWrapper = decKey1(intWrapper);        
        decKey1(intWrapper);   
        System.out.println("inc  3 "+intWrapper.key);        
    }
    
    public IntWrapper decKey1(IntWrapper intWrapper){
        intWrapper = new IntWrapper(-20);
                
        //intWrapper.key --;
        System.out.println("dec "+intWrapper.key);
        return intWrapper;
    }    
}
