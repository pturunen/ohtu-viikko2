package statistics.matcher;

import statistics.Player;

public class Or extends Matcher{

    private Matcher matchersA;
    private Matcher matchersB;

    public Or(Matcher a, Matcher b) {
        this.matchersA = a;
        this.matchersB = b;
    }

    protected boolean matchCondition(){
        return true;
    }
    
    protected boolean returnCondition(){
        return true;
    }
    
    @Override
    public boolean matches(Player p) {
        if (matchersA.matches(p) == matchCondition()) {
                return returnCondition();
            }
        else {
           return matchersB.matches(p) == matchCondition();
        }
    }
}
