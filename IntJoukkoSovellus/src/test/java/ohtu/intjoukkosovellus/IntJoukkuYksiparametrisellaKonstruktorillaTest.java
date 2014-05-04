
package ohtu.intjoukkosovellus;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class IntJoukkuYksiparametrisellaKonstruktorillaTest extends IntJoukkoTest {
    
    @Before
    @Override
    public void setUp() {
        joukko = new IntJoukko(3);
        joukko.lisaa(10);
        joukko.lisaa(3);
        aJoukko = new IntJoukko(5);
        aJoukko.lisaa(1);
        aJoukko.lisaa(2);
        aJoukko.lisaa(3);
        bJoukko = new IntJoukko(5);
        bJoukko.lisaa(2);
        bJoukko.lisaa(3);
        bJoukko.lisaa(4);
        bJoukko.lisaa(5);
    }
    
    @Test
    public void kapasiteettiAlleNollan() {
        try {
            IntJoukko joukkoAlustamatta = new IntJoukko(-1);
        }
        catch (IndexOutOfBoundsException e){
                  System.out.print("Virheen tulisi jäädä kiinni ennen tuotantoa");
        }
    }
    
    // perii kaikki testit luokasta IntJoukkoTest
}
