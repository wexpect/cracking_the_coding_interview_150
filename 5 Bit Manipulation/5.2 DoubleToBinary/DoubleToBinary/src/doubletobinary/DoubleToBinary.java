/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doubletobinary;

/**
 *
 * @author Rui
 */
public class DoubleToBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoubleToBinary db = new DoubleToBinary();
        
        double num = 0.76;
        db.printBinary(num);
        
    }
    
    public void printBinary(double num){
        String binaryNum = ".";
        int count = 1;
        
        double value = 0;
        double residue = num;
        
        while(true){
            value = residue * 2;
            
            binaryNum = binaryNum + (int)value;
            count++;
            
            residue = value % 1;
            
            if( count == 32 && residue != 0){
                System.out.println("ERROR");
                System.out.println("count = " + count);
                System.out.println(binaryNum);                
                break;
            }
            
            if( residue == 0){
                System.out.println("count = " + count);
                System.out.println(binaryNum);
                break;
            }
            
        }
    
    
    }
}
