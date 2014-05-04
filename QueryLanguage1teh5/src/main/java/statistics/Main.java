package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI"),
                             new HasFewerThan(25,"goals")
        );
        
        Matcher m2 = new Or( new HasAtLeast(30, "goals"),
                             new HasFewerThan(3, "assists")
        );
        
        Matcher m3 = new Not( new HasAtLeast(30, "goals"),
                             new HasFewerThan(3, "assists")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        System.out.println("or tulokset");
        for (Player player : stats.matches(m2)) {
            System.out.println( player );
        }
        
        System.out.println("not tulokset");
        for (Player player : stats.matches(m3)) {
            System.out.println( player );
        }
    }
}
