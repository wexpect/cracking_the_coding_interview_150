/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Rui
 */
public class SharedMemory {
    private Semaphore clientIn;
    private Semaphore mesCtoS;
    private Semaphore mesStoC;
    
    private Semaphore mesSema;
    private String mes;
    
    public SharedMemory(){
        clientIn = new Semaphore(0);
        mesCtoS = new Semaphore(0);
        mesStoC = new Semaphore(0);
        
        mesSema = new Semaphore(1);
        mes = null;
    }
    
    public void acquireClientIn() throws InterruptedException{
        clientIn.acquire();    
    }
    
    public void releaseClientIn(){
        clientIn.release();    
    }    
    
    public void acquireMesCtoS() throws InterruptedException{
        mesCtoS.acquire();    
    }
    
    public void releaseMesCtoS(){
        mesCtoS.release();    
    }        

    public void acquireMesStoC() throws InterruptedException{
        mesStoC.acquire();    
    }
    
    public void releaseMesStoC(){
        mesStoC.release();    
    }            
    
    public void writeMes(String m) throws InterruptedException{
        mesSema.acquire();
        mes = m;
        mesSema.release();
    }
    
    public String readMes() throws InterruptedException{                
        mesSema.acquire();
        String m = mes;                        
        mesSema.release();
        return m;
    }
    
}
