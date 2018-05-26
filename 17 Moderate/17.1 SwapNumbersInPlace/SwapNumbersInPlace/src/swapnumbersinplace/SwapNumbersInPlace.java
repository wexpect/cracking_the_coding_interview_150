/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swapnumbersinplace;

/**
 *
 * @author Rui
 */


public class SwapNumbersInPlace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int a = 5; 
        int b = 2;

        System.out.println(a);
        System.out.println(b);        
        
        SwapNumbersInPlace snip = new SwapNumbersInPlace();
        
        // Solu 2: works
        Container con = snip.swap(a, b);    
        
        // Solu 3: works
        //Container con = snip.swapBitManipulation(a, b);    
                
        
        a = con.a;
        b = con.b;                
        
        System.out.println(a);
        System.out.println(b);
    }
    
    // solu 2: works
    public Container swap(int a, int b){

        // Solu 2.1: works
//        a = a - b;
//        b = b + a;
//        a = b - a;     
        
        
        // Solu 2.2: works
        a = a + b;
        b = a - b;
        a = a - b;
        
        Container con = new Container();
        con.a = a;
        con.b = b;
        
        return con;
    }
    
    public class Container{
        public int a;
        public int b;
    }
    
    // Solu 3: works
    public Container swapBitManipulation(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        Container con = new Container();
        con.a = a;
        con.b = b;
        
        return con;        
    }
}



// Solu 1: using Integer does not point to the same Object...

//public class SwapNumbersInPlace {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        
//        Integer a = 5; 
//        Integer b = 2;
//
//        System.out.println(a);
//        System.out.println(b);        
//        
//        SwapNumbersInPlace snip = new SwapNumbersInPlace();
//        snip.swap(a, b);
//        
//        System.out.println(a);
//        System.out.println(b);
//    }
//    
//    public void swap(Integer a, Integer b){
//        a = (Integer) (a - b);
//        b = (Integer) (b + a);
//        a = (Integer) (b - a);     
//        
//        System.out.println(a);
//        System.out.println(b);        
//    }

//}
