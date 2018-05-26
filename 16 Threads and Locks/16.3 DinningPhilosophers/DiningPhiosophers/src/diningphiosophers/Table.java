/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diningphiosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Rui
 */
public class Table{
    private int numPeople;
    private int numFood;
    
    public boolean[] csAvail;
    public Lock[] locks;
    private Lock foodLock;

    public Table(int numPeople, int numFood){
        this.numPeople = numPeople;
        this.numFood = numFood;
        
        csAvail = new boolean[numPeople];
        for(int i = 0; i < numPeople; i++){
            csAvail[i] = true;
        }
        
        locks = new Lock[numPeople];
        for(int i = 0; i < numPeople; i++){
            locks[i] = new ReentrantLock();
        }    
        
        foodLock = new ReentrantLock();
    }
    
    public boolean getCS(int id){
        if( id == -1 )
            id = numPeople - 1;
        
        locks[id].lock();
        
        boolean gotCS = false;
        try{                        
            if( csAvail[id] ){
                csAvail[id] = false;
                gotCS = true;
            }
        }
        finally{
            locks[id].unlock();
        }
        
        return gotCS;            
    }
    
    public void putCS(int id){
        if( id == -1)
            id = numPeople - 1;
        
        locks[id].lock();
        try{
            csAvail[id] = true;
        }
        finally{
            locks[id].unlock();
        }    
    }

    public boolean eatFood(){
        foodLock.lock();
        boolean gotFood = false;
        try{
            if( numFood > 0 ){
                numFood--;
                gotFood = true;
            }
        }
        finally{
            foodLock.unlock();
        }
        
        return gotFood;
    }
}
