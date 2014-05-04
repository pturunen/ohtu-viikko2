package ohtu.intjoukkosovellus;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntJoukkoTest {

    IntJoukko joukko;
    IntJoukko aJoukko;
    IntJoukko bJoukko;

    @Before
    public void setUp() {
        joukko = new IntJoukko();
        joukko.lisaa(10);
        joukko.lisaa(3);
        aJoukko = new IntJoukko();
        aJoukko.lisaa(1);
        aJoukko.lisaa(2);
        aJoukko.lisaa(3);
        bJoukko = new IntJoukko();
        bJoukko.lisaa(2);
        bJoukko.lisaa(3);
        bJoukko.lisaa(4);
        bJoukko.lisaa(5);
    }

    @Test
    public void lukujaLisattyMaara() {
        joukko.lisaa(4);
        assertEquals(3, joukko.mahtavuus());
    }

    @Test
    public void samaLukuMeneeJoukkoonVaanKerran() {
        joukko.lisaa(10);
        joukko.lisaa(3);
        assertEquals(2, joukko.mahtavuus());
    }

    @Test
    public void vainLisatytLuvutLoytyvat() {
        assertTrue(joukko.kuuluu(10));
        assertFalse(joukko.kuuluu(5));
        assertTrue(joukko.kuuluu(3));
    }

    @Test
    public void poistettuEiOleEnaaJoukossa() {
        joukko.poista(3);
        assertFalse(joukko.kuuluu(3));
        assertEquals(1, joukko.mahtavuus());
    }
    
    @Test
    public void poistaOlematonJoukosta() {
        assertFalse(joukko.kuuluu(30));
        assertFalse(joukko.poista(30));
    }
    
    @Test
    public void leikkausToimiva() {
        IntJoukko uusiJoukko = IntJoukko.leikkaus(aJoukko, bJoukko);
        assertTrue(uusiJoukko.kuuluu(2));
        assertTrue(uusiJoukko.kuuluu(3));
        assertFalse(uusiJoukko.kuuluu(1));
        assertFalse(uusiJoukko.kuuluu(4));
        assertFalse(uusiJoukko.kuuluu(5));
    }
    
    @Test
    public void erotusToimiva() {
        IntJoukko uusiJoukko = IntJoukko.erotus(aJoukko, bJoukko);
        assertTrue(uusiJoukko.kuuluu(1));
        assertFalse(uusiJoukko.kuuluu(2));
        assertFalse(uusiJoukko.kuuluu(3));
        assertFalse(uusiJoukko.kuuluu(4));
        assertFalse(uusiJoukko.kuuluu(5));
    }
    
    @Test
    public void palautetaanOikeaTaulukko() {
        int[] odotettu = {3, 55, 99};
        
        joukko.lisaa(55);
        joukko.poista(10);
        joukko.lisaa(99);

        int[] vastaus = joukko.toIntArray();
        Arrays.sort(vastaus);
        assertArrayEquals(odotettu, vastaus);
    }
    
    
    @Test
    public void toimiiKasvatuksenJalkeen(){
        int[] lisattavat = {1,2,4,5,6,7,8,9,11,12,13,14};
        for (int luku : lisattavat) {
            joukko.lisaa(luku);
        }
        assertEquals(14, joukko.mahtavuus());
        assertTrue(joukko.kuuluu(11));
        joukko.poista(11);
        assertFalse(joukko.kuuluu(11));
        assertEquals(13, joukko.mahtavuus());
    }
    
    @Test
    public void toStringToimii(){
        assertEquals("{10, 3}", joukko.toString());
    }
}
