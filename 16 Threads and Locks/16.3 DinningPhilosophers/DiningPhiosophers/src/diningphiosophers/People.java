/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphiosophers;

import java.util.Random;

/**
 *
 * @author Rui
 */
public class People implements Runnable{
    private int ID;
    private int myFood;
    private Table table;
    private static final int EATTIME = 5;
        
    public People(int ID, Table table){
        this.ID = ID;
        myFood = 0;
        this.table = table;
    }
    
    public void run(){
        try{
            Random rg = new Random();
            boolean hasFood = true;
            
            while(hasFood){
                
                if(table.getCS(ID) ){
                    System.out.printf("P %d gets left\n", ID);
                    
                    if(table.getCS(ID-1)){
                        System.out.printf("P %d gets right\n", ID);
                        
                        if( table.eatFood() ){
                            myFood++;                                     
                            System.out.printf("P %d has eaten food for %d times\n", ID, myFood);
                        
                            table.putCS(ID);
                            System.out.printf("P %d puts left\n", ID); 
                            table.putCS(ID-1);                           
                            System.out.printf("P %d puts right\n", ID);                             

                            System.out.printf("P %d will take %d secs to digest\n", ID, EATTIME);                         
                            Thread.sleep( EATTIME * 1000 );                              
                        }
                        else{
                            hasFood = false;
                            System.out.printf("P %d finds NO food left\n", ID);  
                            
                            table.putCS(ID);
                            System.out.printf("P %d puts left\n", ID); 
                            table.putCS(ID-1);                           
                            System.out.printf("P %d puts right\n", ID);                              
                        }                 
                    }
                    else{
                        table.putCS(ID);
                        System.out.printf("P %d does not get right, so puts left\n", ID); 
                    }                                            
                }
                else{
                    System.out.printf("P %d dose not get left\n", ID);
                }
                
                int waitTime = (rg.nextInt(4)+2) ;
                System.out.printf("P %d waits %d secs\n", ID, waitTime); 
                Thread.sleep( waitTime * 1000 );                        
            }        
            
            System.out.printf("P %d eats a totla of %d foods\n", ID, myFood); 
        }
        catch( InterruptedException e){
        }    
    }

}