/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convertxml;

import java.util.HashMap;

/**
 *
 * @author Rui
 */
public class ConvertXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConvertXML cx = new ConvertXML();
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("family",1);
        map.put("person",2);
        map.put("firstName",3);
        map.put("lastName",4);
        map.put("state",5);
        
        String ele = "<family lastName=\"McDowell\" state=\"CA\"> <person firstName=\"Gayle\">Some Message</person> </family>";
        
        System.out.println( cx.convert(ele, map) );
    }
    
    public String convert(String ele, HashMap<String, Integer> map){
        if( ele == null )
            return null;
        
        ele = ele.trim();
        
        if( ele.charAt(0) != '<')
            return ele;
        
        String encodedStr = "";
        int indS = 1;
        boolean foundEleTag = false;
        boolean isFirstQuote = true;
        
        int childEndInd = -1;
        
        for(int i = 1; i < ele.length(); i++){
            char c = ele.charAt(i);
            
            if( c == ' ' && !foundEleTag){
                String tag = ele.substring(indS, i).trim();
                int value = map.get(tag);
                encodedStr = value + " ";
                
                childEndInd = ele.length()-1 - tag.length() -3;
                
                foundEleTag = true;
                
                indS = i+1;            
            }
            else if( c == '=' ){
                String tag = ele.substring(indS, i).trim();
                int value = map.get(tag);
                encodedStr += value + " ";
            }
            else if( c == '"' && isFirstQuote){
                indS = i + 1;
                
                isFirstQuote = false;
            }
            else if( c == '"' && !isFirstQuote){
                String value = ele.substring(indS, i);
                encodedStr += value + " ";
                
                isFirstQuote = true;
            }
            else if( c == ' ' && foundEleTag){
                indS = i + 1;
            }
            else if( c == '>'){
                encodedStr += 0 + " ";
                
                System.out.println( ele.substring(i+1, childEndInd+1) );
                
                encodedStr += convert( ele.substring(i+1, childEndInd+1), map );
                encodedStr += " "+0;
                break;
            }        
        }
        return encodedStr;
    }
}
