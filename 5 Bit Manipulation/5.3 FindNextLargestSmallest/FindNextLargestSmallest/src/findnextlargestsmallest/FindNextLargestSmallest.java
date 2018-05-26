/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package findnextlargestsmallest;

/**
 *
 * @author Rui
 */
public class FindNextLargestSmallest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //case 1: works 
        String str = "1010"; 
        
        //case 2: works
        //String str = "0011";
        
        //case 3: works
        //String str = "1100";
                
        FindNextLargestSmallest fnls = new FindNextLargestSmallest();
                
        fnls.getLS(str);
    }
    
    
    public void getLS(String str){
        if( Integer.parseInt(str, 2) == 0){
            System.out.println("num = 0");
            return;
        }
        
        int countOne = getCount(str);
        
        
        if( hasZeroOnLeftOfOne(str) ){
            int numL = getNext(str, countOne, 1);
            System.out.println("numL = " + Integer.toBinaryString(numL));
        }
        
        if( hasZeroOnRightOfOne(str) ){
            int numS = getNext(str, countOne, -1);
            System.out.println("numS = " + Integer.toBinaryString(numS));
        }        
    
    }
            
    public boolean hasZeroOnLeftOfOne(String str){
        
        for( int i = str.length() - 1; i >= 0; i--){
            if( str.charAt(i) == '1' ){
                for( int j = i-1; j >= 0; j--){
                    if( str.charAt(j) == '0' ){
                        return true;
                    }
                }
            }        
        }        
        return false;    
    }
            
    public boolean hasZeroOnRightOfOne(String str){       
        
        for( int i = 0; i < str.length(); i++){
            if( str.charAt(i) == '1' ){
                for( int j = i+1; j < str.length(); j++){
                    if( str.charAt(j) == '0' )
                        return true;
                }
            }        
        }        
        return false;    
    }
        
    public int getCount(String str){                
        int count = 0;
        
        for(int i = 0; i < str.length(); i++){
            if( str.charAt(i) == '1' )
                count++;        
        }        
        return count;    
    }
    
    public int getNext(String str, int countOne, int d){
        
        int num = Integer.parseInt(str, 2);
        
        while(true){
            num += d;
            int count = getCount( Integer.toBinaryString(num) );
            
            if( count == countOne)
                return num;        
        }
    }
    
}
