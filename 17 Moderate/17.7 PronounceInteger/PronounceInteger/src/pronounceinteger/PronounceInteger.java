///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package pronounceinteger;
//
//import java.util.HashMap;
//
///**
// *
// * @author Rui
// */
//public class PronounceInteger {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        PronounceInteger pi = new PronounceInteger();
//        
//        String str = pi.pro(-213123321);
//        System.out.println(str);
//    }
//    
//    public String pro(int n){
//        String str = "";
//        int v = 0;
//        int u = 0;
//        
//        if( n < 0 ){
//            str = "Negative ";
//            n = -n;
//        }
//        
//        HashMap<Integer, String> hm = makeHS();        
//        
//        if( n >= 1000000){
//            u = 1000000;
//            v = n / u;
//            n = n % u;
//            
//            str += proHelp(v, hm) + hm.get(u);
//        }
//        
//        if( n >= 1000 ){
//            u = 1000;
//            v = n / u;
//            n = n % u;
//            
//            str += proHelp(v, hm) + hm.get(u);
//        }
//        
//        if( 0 <= n && n <= 999){
//            str += proHelp(n, hm);
//        }
//        
//        return str;
//    }
//    
//    public String proHelp(int num, HashMap<Integer, String> hm){        
//        
//        String str = "";
//        int v = 0;
//        int u = 0;
//        
//        if( num >= 100){
//            u = 100;
//            v = num / u;
//            num = num % u;
//            
//            str += hm.get(v) + hm.get(u);            
//        }
//        
//        if( 20 <= num && num <= 99){
//            u = 10;
//            v = num - num % u;
//            num = num % u;
//            
//            str += hm.get(v);            
//        }        
//        
//        if( 0 <= num && num <=19 ){
//            str += hm.get(num);
//        }
//        
//        return str;
//    }
//    
//    public HashMap<Integer, String> makeHS(){
//        HashMap<Integer, String> hm = new HashMap<Integer, String>();
//        
//        hm.put(0,"Zero");
//        hm.put(1,"One ");
//        hm.put(2,"Two ");
//        hm.put(3,"Three ");
//        hm.put(13,"Thirteen ");
//        
//        hm.put(10,"Ten ");
//        hm.put(20,"Twenty ");
//        hm.put(30,"Thirty ");
//        
//        hm.put(100,"Hundred ");
//        hm.put(1000,"Thousand, ");
//        hm.put(1000000,"Million, ");
//        
//        return hm;
//    }
//    
//    
//}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pronounceinteger;

import java.util.HashMap;

/**
 *
 * @author Rui
 */
public class PronounceInteger {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PronounceInteger pi = new PronounceInteger();
        
        int n = -213123321;
        int unit = (int) Math.pow(10, 6);
        
        // Solu 1
        String str = pi.pro(n, unit);
        System.out.println(str);
        
        // Solu 2.1:                
        System.out.println(pi.print21(n));
        
        // Solu 2.2:                
        System.out.println(pi.print22(n));        
    }
    
    

    // Solu 2: better        
   
    // Solu 2.1: iteration
    public String print21(int n){
        if( n == 0)
            return "Zero";
        
        String strNeg = "";
        if( n < 0){
            strNeg = "Negative ";
            n = -n;
        }
        
        HashMap<Integer, String> hm = makeHS();
        
        String str = "";
        int unit = 1;
        while( n > 0 ){
            if( n % 1000 != 0){
                str = printHundred( n % 1000, hm) + getUnit(unit) + str;
            }
            n = n / 1000;
            unit++;
        }
        
        return strNeg + str;    
    }
    
    // Solu 2.2: recursion
    public String print22(int n){
        if( n == 0)
            return "Zero";

        HashMap<Integer, String> hm = makeHS();    
               
        if( n > 0){
            return print22Help(n, 1, hm);
        }
        else{
            return "Negative "+ print22Help(-n, 1, hm);            
        }        
    }
    
    public String print22Help(int n, int unit, HashMap<Integer, String> hm){
        if( n == 0)
            return "";
        
        String str = print22Help( n / 1000, unit+1, hm) + printHundred( n % 1000, hm) + getUnit( unit );
        return str;
    }
    
    public String printHundred(int n,  HashMap<Integer, String> hm){
        String str = "";
        
        if( n / 100 != 0 ){
            str = hm.get( n / 100) + " Hundred ";
        }
        
        int n1 = n % 100;
        if( n1 >= 20){
            str += hm.get( n1 - n1 % 10) + hm.get( n1 % 10);
        }
        else{
            str += hm.get(n1);
        }
        
        return str;
    }
    
    public String getUnit(int unit){
        switch(unit){
            case 1:
                return "";
            case 2:
                return " Thousand, ";
            case 3:
                return " Million, ";
            case 4:
                return " Billion, ";
            default:
                return "";
        }
    }
    
    
    // Solu 1:
    public String pro(int n, int u){
        String str = "";
        int v = 0;
        
        if ( u < 1000 )
            u = 1000;
        
        if( n < 0 ){
            str = "Negative ";
            n = -n;
        }
        
        HashMap<Integer, String> hm = makeHS();        
        
        if( n >= u){            
            v = n / u;
            n = n % u;
            
            str += proHelp(v, hm) + hm.get(u) + pro(n, u/1000);            
        }                
        else{ // ( 0 <= n && n <= 999)
            str += proHelp(n, hm);
        }
        
        return str;
    }
    
    public String proHelp(int num, HashMap<Integer, String> hm){        
        
        String str = "";
        int v = 0;
        int u = 0;
        
        if( num >= 100){
            u = 100;
            v = num / u;
            num = num % u;
            
            str += hm.get(v) + hm.get(u);            
        }
        
        if( 20 <= num && num <= 99){
            u = 10;
            v = num - num % u;
            num = num % u;
            
            str += hm.get(v);            
        }        
        
        if( 0 <= num && num <=19 ){
            str += hm.get(num);
        }
        
        return str;
    }
    

    public HashMap<Integer, String> makeHS(){
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        
        hm.put(0,"Zero");
        hm.put(1,"One ");
        hm.put(2,"Two ");
        hm.put(3,"Three ");
        hm.put(13,"Thirteen ");
        
        hm.put(10,"Ten ");
        hm.put(20,"Twenty ");
        hm.put(30,"Thirty ");
        
        hm.put(100,"Hundred ");
        hm.put(1000,"Thousand, ");
        hm.put(1000000,"Million, ");
        
        return hm;
    }
    
    
}
