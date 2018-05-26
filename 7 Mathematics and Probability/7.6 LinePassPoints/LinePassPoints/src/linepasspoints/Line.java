
package linepasspoints;

public class Line{
    public boolean slopeExist;
    
    public double slope;
    public double yIntercept;
    
    public double xIntercept;
    
    private static double epsilon = 0.000001;
    
    public Line(Point p1, Point p2){
        if( Math.abs( p1.x - p2.x) < epsilon ){
            slopeExist = false;
            xIntercept = p1.x;
        }
        else{
            slopeExist = true;
            slope = (p2.y - p1.y) / (p2.x - p1.x);
            yIntercept = p1.y - slope * p1.x;
        }    
    }
    
    public boolean passes(Point p){
        if( slopeExist )
            return Math.abs( p.y - (slope * p.x + yIntercept) ) < epsilon;
        else
            return Math.abs( p.x - xIntercept) < epsilon;    
    }
    
    public String toString(){
        if(slopeExist)
            return "slope = "+slope+", yIntercept = "+yIntercept;
        else
            return " xIntercept = "+xIntercept;
    }
    
    
    public int hashCode(){
        if( slopeExist )
            return (int) ( slope + 23 * yIntercept  );
        else
            return (int) xIntercept;
    }
    
    public boolean equals(Object o){
        Line l = (Line) o;
        
        if( (slopeExist && l.slopeExist) && (Math.abs(slope - l.slope) < epsilon  ) && (Math.abs(yIntercept - l.yIntercept) < epsilon ) ){
            return true;
        }
        else if( (!slopeExist && !l.slopeExist) && (Math.abs(xIntercept - l.xIntercept) < epsilon  )   ){
            return true;
        }
        else
            return false;
    }
}