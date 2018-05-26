///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package addtwonumber;
//
///**
// *
// * @author Rui
// */
//public class AddTwoNumber {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//                
//        int n1 = 3;
//        int n2 = 5;
//        
//        AddTwoNumber atn = new AddTwoNumber();
//        
//        int result = atn.add(n1, n2);
//        
//        System.out.println(Integer.toBinaryString(n1));
//        System.out.println(Integer.toBinaryString(n2));
//        System.out.println(Integer.toBinaryString(result));
//        
//        System.out.println(result);
//    }
//    
//    public int add(int n1, int n2){
//        int result = 0;
//        int cIn = 0;
//        
//        int mask = 0x1;
//        
//        for(int i = 0; i <= 30; i++){
//            int a = n1 & mask;
//            int b = n2 & mask;            
//            
//            int s = a ^ b ^ cIn;
//            int cOut = (a & b) | (b & cIn ) | (a & cIn);
//            
//            result = result | ( s << i);
//            
//            cIn = cOut;
//            
//            n1 = n1 >>> 1;
//            n2 = n2 >>> 1;
//        }
//        
//        return result;
//    }
//}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package addtwonumber;

/**
 *
 * @author Rui
 */
public class AddTwoNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
                
        int n1 = 0x7fffffff;
        int n2 = -3;
        
        AddTwoNumber atn = new AddTwoNumber();
        
        int result = atn.add(n1, n2);
        
        System.out.println(Integer.toBinaryString(n1));
        System.out.println(Integer.toBinaryString(n2));
        System.out.println(Integer.toBinaryString(result));
        
        System.out.println(result);
    }
    
    public int add(int n1, int n2) throws Exception{
        int signN1 = n1 >>> 31;
        int signN2 = n2 >>> 31;
        
        int result = 0;
        int cIn = 0;
        
        int mask = 0x1;
        
        for(int i = 0; i <= 31; i++){
            int a = n1 & mask;
            int b = n2 & mask;            
            
            int s = a ^ b ^ cIn;
            int cOut = (a & b) | (b & cIn ) | (a & cIn);
            
            result = result | ( s << i);
            
            cIn = cOut;
            
            n1 = n1 >>> 1;
            n2 = n2 >>> 1;
        }
        
        if( signN1 == signN2 ){
            int signResult = result >>> 31;
            if( signN1 != signResult ){
                System.out.println("Overfolw happens.");
                throw new Exception("Overfolw happens.");
            }
        }
        
        return result;
    }
}
