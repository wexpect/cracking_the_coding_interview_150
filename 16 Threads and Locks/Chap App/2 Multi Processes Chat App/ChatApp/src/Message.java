
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rui
 */
public class Message{
    public int from;
    public int to;
    public String str;
    
    public Message(int f, int t, String s){
        from = f;
        to = t;
        str = s;
    }
    
    public Message(){
    }
        
}
