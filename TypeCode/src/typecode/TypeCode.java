/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package typecode;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rui
 */
public class TypeCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Map<String, Color> favoriteColors = new HashMap<String, Color>();

        favoriteColors.put("Juliet", Color.PINK);

        Color julietsFavoriteColor = favoriteColors.get("Juliet");

        favoriteColors.remove("Juliet");        
        
        
        
        
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        
        accounts.add(new BankAccount(1001));
        accounts.add(3, new BankAccount(1008));
                
        BankAccount anAccount = accounts.get(2);                
        
        accounts.remove(0);
        
        accounts.set(2,anAccount);
        
        accounts.size();
        
     
        
        
        StringBuffer sentence = new StringBuffer();
        sentence.append(w);
        
        sentence.toString();
    }
}
