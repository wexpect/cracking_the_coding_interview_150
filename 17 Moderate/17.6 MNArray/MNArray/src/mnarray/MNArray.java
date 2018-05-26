/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnarray;

/**
 *
 * @author Rui
 */
public class MNArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {1,2,4,6, 7,10,11,7,12,6,7,16,18, 18,19};
        
        MNArray mn= new MNArray();

        // Solu 4:
        Container con = mn.getMN4(arr);
        System.out.println(con.m + ", "+con.n);        
        
        // Solu 2:
        con = mn.getMN(arr);
        System.out.println(con.m + ", "+con.n);
    }
    
    // Solu 4: better
    public Container getMN4(int[] arr){
        if( arr == null)
            return null;
        
        if(arr.length == 1){
            Container con = new Container();
            con.m = 0;
            con.n = 0;
            return con;
        }
        
        int minValue = arr[arr.length-1];
        int m = -1;
        for(int i = arr.length - 2; i >=0; i--){
            if( minValue >= arr[i] )
                minValue = arr[i];
            else
                m = i;
        }
        
        if( m == -1 ){
            Container con = new Container();
            con.m = 0;
            con.n = 0;
            return con;
        }
        
        int maxValue = arr[0];
        int n = -1;
        for(int i = 1; i <= arr.length-1; i++){
            if( maxValue <= arr[i] )
                maxValue = arr[i];
            else
                n = i;
        }
        
        Container con = new Container();
        con.m = m;
        con.n = n;
        return con;                
    }
    
    
    // Solu 2:
    public Container getMN(int[] arr){
        if( arr == null)
            return null;
        
        Container con = new Container();
        
        boolean mFound = false;
        for(int i = 0; i < arr.length && !mFound; i++){
            for(int j = i + 1; j < arr.length && !mFound; j++){
                if( arr[i] > arr[j] ){
                    con.m = i;
                    mFound = true;
                }
                    
            }
        }
        
        boolean nFound = false;
        for(int i = arr.length - 1; i >= 0 && !nFound; i--){
            for(int j = i - 1; j >= 0 && !nFound; j--){
                if( arr[i] < arr[j] ){
                    con.n = i;
                    nFound = true;
                }
                    
            }
        }
        
        return con;        
    }
    
    public class Container{
        public int m = 0;
        public int n = 0;      
    }    
}
