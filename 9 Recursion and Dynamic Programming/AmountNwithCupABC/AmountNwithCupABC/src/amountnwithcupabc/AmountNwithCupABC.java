/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package amountnwithcupabc;

import java.util.LinkedList;

/**
 *
 * @author Rui
 */
public class AmountNwithCupABC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AmountNwithCupABC obj = new AmountNwithCupABC();
        
        
    // Solu 3 is for: 
    // minimize the total number of cups, so that the total amount exactly equals to what is required, n.  
        int N = 99;
        
        // Solu 3.1
        int sizeA = 25;
        int sizeB = 10;
        int sizeC = 5;
        int sizeD = 1;
        
        obj.getWays(N, sizeA, sizeB, sizeC, sizeD);
        System.out.println( obj.countA31 + " " + obj.countB31 + " " + obj.countC31 + " " + obj.countD31);
                
        // Solu 3.2        
        obj.getNum32(N, 25);        
        System.out.println( obj.numList);

        
    // Solu 1 and Solu 2 are for: 
    // minimize the total number of cups, so that the total amount covers (not necessarily equal to) what is required, n.        
        int n = 11;
        int a = 1;
        int b = 2;
        int c = 3;
        
        // Solu 1
        obj.go(n,a,b,c);
        
        // Solu 2
        obj.go2(n, a, b, c);
        
    }    
    
    // Solu 3
    // Solu 3.1: iteration
    public int countA31 = -1;
    public int countB31 = -1;
    public int countC31 = -1;
    public int countD31 = -1;
    
    public void getWays(int n, int sizeA, int sizeB, int sizeC, int sizeD){
        if( n <= 0 || sizeA <= 0 || sizeB <= 0 || sizeC <=0 || sizeD <= 0)
            return;
        
        for(int numA = n / sizeA; numA >= 0; numA--){
            int remA = n - sizeA * numA;

            System.out.println("A "+ numA + " " + remA);
            
            for(int numB = remA / sizeB; numB >= 0; numB--){
                int remB = remA - sizeB * numB;
            
                System.out.println("B "+ numB + " " + remB);
                
                for(int numC = remB / sizeC; numC >= 0; numC--){            
                    int remC = remB - sizeC * numC;                
                    
                    int residue = remC % sizeD;                    
                    
                    System.out.println("C "+ numC + " " + remC + ", residue "+residue);
                   
                    if( residue == 0 ){
                        countA31 = numA;
                        countB31 = numB;
                        countC31 = numC;
                        countD31 = remC / sizeD;
                        return;
                    }            
                }
            }       
        }  
    }
    
    // Solu 3.2: recursion            
    public LinkedList<Integer> numList = new LinkedList<Integer>();
    
    public boolean getNum32(int n, int size){
        
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
            for(int i = n/size; i >= 0; i--){
                if( getNum32( n - size * i, nextSize) ){
                    numList.addFirst( i );
                    return true;
                }
            }
            return false;
        }
        else{
            if( n % 1 == 0 ){
                numList.addFirst( n / 1 );
                return true;
            }
            else
                return false;
        }
    
    }
    
  
    
    // Solu 1: both 1.1 and 1.2 work well
    
    private int countA = 0;
    private int countB = 0;
    private int countC = 0;
    
    public void go(int n, int a, int b, int c){
        //int num = getNum(n,a,b,c);
        int num = getNum2(n,a,b,c);
        System.out.printf("num = %d: numA = %d, numB = %d, numC = %d\n", num, countA, countB, countC);        
    }
    
    // Solu 1.1
    public int getNum(int n, int a, int b, int c){
        if( n >= c){
            countC++;
            return 1 + getNum(n - c, a,b,c);
        }         
        else if( n >= b){
            countB++;
            return 1 + getNum(n - b, a,b,c);
        }         
        else if( n >= a){
            countA++;
            return 1 + getNum(n - a, a,b,c);
        }
        else if(n > 0){  // must pay attention to n > 0 and n == 0
            countA++;
            return 1;
        }    
        else{
            return 0;
        }            
    }
    
    // Solu 1.2
    public int getNum2(int n, int a, int b, int c){
        if( n >= c){
            int num = n / c;            
            countC += num;
            return num + getNum(n - num*c, a,b,c);
        }         
        else if( n >= b){
            int num = n / b;
            countB += num;
            return num + getNum(n - num*b, a,b,c);
        }         
        else if( n >= a){
            int num = n / a;
            countA += num;
            return num + getNum(n - num*a, a,b,c);
        }
        else if(n > 0){  // must pay attention to n > 0 and n == 0
            countA++;
            return 1;
        }    
        else{
            return 0;
        }            
    }
    
    
    // Solu 2
    public int go2(int n, int a, int b, int c){
        
        int numCupTypes = 3;
        int[] cup = {0,0,0};
        int[] capacity = {a,b,c};
        
        
        int remain = n;
        
        for( int i = numCupTypes-1; i >= 0 && remain > 0 ; i--){
            if( remain >= capacity[i] ){
                cup[i] = remain / capacity[i];
                remain = remain - cup[i] * capacity[i];
            }
            else
                cup[i] = 0;        
        }
        
        if( remain > 0 )
            cup[0]++;
        
        int num = cup[0] + cup[1] + cup[2];
        System.out.printf("num = %d: numA = %d, numB = %d, numC = %d\n", num, cup[0], cup[1], cup[2]);  
        
        return num;    
    }
    
    
    
}
