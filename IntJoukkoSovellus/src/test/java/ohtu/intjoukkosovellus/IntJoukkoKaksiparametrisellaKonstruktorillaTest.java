
package ohtu.intjoukkosovellus;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoKaksiparametrisellaKonstruktorillaTest extends IntJoukkoTest {
    
    @Before
    public void setUp() {
        joukko = new IntJoukko(4, 2);
        joukko.lisaa(10);
        joukko.lisaa(3);
        aJoukko = new IntJoukko(5,5);
        aJoukko.lisaa(1);
        aJoukko.lisaa(2);
        aJoukko.lisaa(3);
        bJoukko = new IntJoukko(5,5);
        bJoukko.lisaa(2);
        bJoukko.lisaa(3);
        bJoukko.lisaa(4);
        bJoukko.lisaa(5);
    }
    
    @Test
    public void kapasiteettiAlleNollanKokoOikein() {
        try {
            IntJoukko joukkoAlustamatta = new IntJoukko(-1 ,2);
        }
        catch (IndexOutOfBoundsException e){
                  System.out.print("Virheen tulisi jäädä kiinni ennen tuotantoa");
        }
    }
    
    @Test
    public void kasvatusKokoAlleNollan() {
        try {
            IntJoukko joukkoAlustamatta = new IntJoukko(5, -1);
        }
        catch (IndexOutOfBoundsException e){
                  System.out.print("Virheen tulisi jäädä kiinni ennen tuotantoa");
        }
    }
}
