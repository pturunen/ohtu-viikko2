
package statistics.matcher;

import statistics.Player;

public class PlaysIn extends Matcher {
    private String team;
    private Matcher m;
    
    public PlaysIn(Matcher m,String team) {
        this.m = m;
        this.team = team;
    }        
    
    @Override
    public boolean matches(Player p) {
        boolean match = p.getTeam().contains(team);
        if (match && m!= null){
            match = m.matches(p);
        }
        return match;
    }
    
}
