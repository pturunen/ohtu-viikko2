package ohtu;

public class Sovelluslogiikka {
 
    private int tulos;
    private int extulos;
 
    public void plus(int luku) {
        extulos = tulos;
        tulos += luku;
    }
     
    public void miinus(int luku) {
        extulos = tulos;
        tulos -= luku;
    }
 
    public void nollaa() {
        extulos = tulos;
        tulos = 0;
    }
    
    public void undo() {
        tulos = extulos;
    }
 
    public int tulos() {
        return tulos;
    }
}