
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

public class HasFewerThan extends HasAtLeast  implements Matcher {

    public HasFewerThan(int value, String category) {
        super(value,category);
    }

    @Override
    protected boolean match(int playersValue){
        return playersValue<getValue();
    }
    
}
