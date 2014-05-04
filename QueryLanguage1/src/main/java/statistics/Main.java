package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        QueryBuilder query = new QueryBuilder();
        //and
        Matcher m = query.playsIn("PHI")
                          .hasAtLeast(100, "goals")
                          .hasAtLeast(10, "assists")
                          .hasFewerThan(250, "goals")
                          .getMatcher();
         
        Matcher m1 = query.hasAtLeast(10, "goals")
                          .hasAtLeast(10, "assists")
                          .hasFewerThan(25, "goals")
                          .getMatcher();
        //or
        Matcher mOr = query.oneOf(m, m1).getMatcher();
 
        for (Player player : stats.matches(mOr)) {
            System.out.println( player );
        }
        
    }
}
