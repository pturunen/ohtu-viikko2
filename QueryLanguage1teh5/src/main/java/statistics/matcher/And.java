package statistics.matcher;

import statistics.Player;

public class And implements Matcher {

    private Matcher[] matchers;

    public And(Matcher... matchers) {
        this.matchers = matchers;
    }
    
    protected boolean matchCondition(){
        return false;
    }
    
    protected boolean returnCondition(){
        return false;
    }
    
    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (matcher.matches(p) == matchCondition()) {
                return returnCondition();
            }
        }
        return !returnCondition();
    }
}
