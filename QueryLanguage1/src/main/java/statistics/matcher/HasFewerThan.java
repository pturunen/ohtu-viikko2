
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public class HasFewerThan extends HasAtLeast {

    public HasFewerThan(Matcher m,int value, String category) {
        super(m,value,category);
    }

    @Override
    protected boolean match(int playersValue){
        return playersValue<getValue();
    }
    
}
