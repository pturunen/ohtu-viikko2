
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public class HasAtLeast implements Matcher {
    
    private int value;
    private String fieldName;

    public HasAtLeast(int value, String category) {
        this.value = value;
        fieldName = "get"+Character.toUpperCase(category.charAt(0))+category.substring(1, category.length());
    }
    
    protected String getFieldName(){
        return fieldName;
    }
    
    protected int getValue(){
        return value;
    }

    protected boolean match(int playersValue){
        return playersValue>=value;
    }
    
    @Override
    public boolean matches(Player p) {
        try {                                    
            Method method = p.getClass().getMethod(fieldName);
            int playersValue = (Integer)method.invoke(p);
            return match(playersValue);
            
        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field "+fieldName.substring(3, fieldName.length()).toLowerCase());
        }       
        
    }    
    
}
