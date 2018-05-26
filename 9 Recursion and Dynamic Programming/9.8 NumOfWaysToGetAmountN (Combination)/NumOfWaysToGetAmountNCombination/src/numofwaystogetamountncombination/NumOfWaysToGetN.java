/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numofwaystogetamountncombination;

/**
 *
 * @author Rui
 */
public class NumOfWaysToGetN {
    public static void main(String[] args){
        NumOfWaysToGetN nwg = new NumOfWaysToGetN();
        
        int n = 100;
        int sizeA = 25;
        int sizeB = 10;
        int sizeC = 5;
        int sizeD = 1;
        
        // Solu 1
        System.out.println( nwg.getWays(n, sizeA, sizeB, sizeC, sizeD) );
        
        // Solu 2
        nwg.getNum(n, sizeA);        
        System.out.println( nwg.countNum );
    }
    
    // Solu 1: iteration
    public int getWays(int n, int sizeA, int sizeB, int sizeC, int sizeD){
        if( n <= 0 || sizeA <= 0 || sizeB <= 0 || sizeC <=0 || sizeD <= 0)
            return 0;
        
        int count = 0;
        
        for(int numA = 0; numA <= n / sizeA; numA++){
            int remA = n - sizeA * numA;

            System.out.println("A "+ numA + " " + remA);
            
            for(int numB = 0; numB <= remA / sizeB; numB++){
                int remB = remA - sizeB * numB;
            
                System.out.println("B "+ numB + " " + remB);
                
                for(int numC = 0; numC <= remB / sizeC; numC++){            
                    int remC = remB - sizeC * numC;                
                    
                    int residue = remC % sizeD;                    
                    
                    System.out.println("C "+ numC + " " + remC + ", residue "+residue);
                   
                    if( residue == 0 ){
                        count++;                        
                        //if required, can also store the current numA, numB, numC, and numD
                    }            
                }
            }       
        }
        
        return count;    
    }
    
    // Solu 2: recursion        
    public int countNum = 0;
    
    public void getNum(int n, int size){
        
        int nextSize = 0;
        switch( size ){
            case 25:
                nextSize = 10;
                break;
            case 10:
                nextSize = 5;
                break;
            case 5:
                nextSize = 1;
                break;  
            case 1:
                break;
        }
        
        if( size >= 5){
            for(int i = 0; i <= n/size; i++){
                getNum( n - size * i, nextSize);
            }        
        }
        else{
            if( n % 1 == 0 )
                countNum++;
        }
    
    }
}
