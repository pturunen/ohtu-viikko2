package statistics.matcher;

import statistics.Player;

public class Or extends And implements Matcher {

    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        super(matchers);
    }

    @Override
    protected boolean matchCondition(){
        return true;
    }
    
    protected boolean returnCondition(){
        return true;
    }
}
