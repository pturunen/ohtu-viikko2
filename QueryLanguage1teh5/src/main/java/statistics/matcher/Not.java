package statistics.matcher;

import statistics.Player;

public class Not extends And implements Matcher {

    private Matcher[] matchers;

    public Not(Matcher... matchers) {
        super(matchers);
    }

    @Override
    protected boolean matchCondition(){
        return true;
    }
    
    protected boolean returnCondition(){
        return false;
    }
}
