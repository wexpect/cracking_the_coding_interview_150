/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package highestboxstack;

/**
 *
 * @author Rui
 */
public class Box{
    public int height;
    public int width;
    public int depth;
    
    public int count;
    public int totalHeight;    
    public Box predecessor;

    public Box(int h, int w, int d){
        height = h;
        width = w;
        depth = h;
        
        count = 1;
        totalHeight = height;
        predecessor = null; // even if no initial value, still need to initialize with null
    }    
}
