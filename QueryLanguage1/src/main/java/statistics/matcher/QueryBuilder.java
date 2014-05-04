
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public class QueryBuilder {
    
    private Matcher m;

    public QueryBuilder() {
        m = null;
     }
    
    public Matcher getMatcher(){
        Matcher temp = m;
        m = null;
        return temp;
    }
    
    public QueryBuilder playsIn(String team){
        this.m = new PlaysIn(m,team);
        return this;
    }
            
    public QueryBuilder hasAtLeast(int value, String category){
        this.m = new HasAtLeast(m,value,category);
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category){
        this.m = new HasFewerThan(m,value,category);
        return this;
    }
    
    public QueryBuilder oneOf(Matcher m, Matcher b){
        this.m = new Or(m,b);
        return this;
    }
}
