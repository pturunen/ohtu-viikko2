
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] ljono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 
    private String nimi;
    
    public IntJoukko() {
        alustaTaulukko(KAPASITEETTI,OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        alustaTaulukko(kapasiteetti,OLETUSKASVATUS);
    }
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");
        }
        alustaTaulukko(kapasiteetti,kasvatuskoko);
    }

     private void alustaTaulukko(int koko, int kasvatuskoko){
        ljono = new int[koko];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }
    
    public boolean lisaa(int luku) {
        boolean ok = false;
        if (!kuuluu(luku)) {
            lisaaTaulukkoon(luku);
            kasvataTaulukkoa();
            ok = true;
            }
        return ok;
    }

    private void lisaaTaulukkoon(int luku){
        ljono[alkioidenLkm] = luku;
        alkioidenLkm++;
    }
    
    private void kasvataTaulukkoa(){
        if (alkioidenLkm % ljono.length == 0) {
            ljono = kopioiTaulukko(alkioidenLkm + kasvatuskoko);
         }
    }
    
    public boolean kuuluu(int luku) {
        boolean loytyi = true;
        if (haeTaulukosta(luku) < 0){
            loytyi = false;
        }
        return loytyi;
    }

    private int haeTaulukosta(int luku){
        int indeksi = -1;
        for (int i = 0; i < alkioidenLkm && (indeksi < 0); i++) {
            if (luku == ljono[i]) {
                indeksi = i;
            }
        }
        return indeksi;
    }
    
    private void poistaAlkio(int indeksi){
        int apu;
        for (int j = indeksi; j < alkioidenLkm - 1; j++) {
             apu = ljono[j];
             ljono[j] = ljono[j + 1];
             ljono[j + 1] = apu;
            }
    }
    
    public boolean poista(int luku) {
        int indeksi = haeTaulukosta(luku);
        if (indeksi != -1) {
            poistaAlkio(indeksi);
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    private int[] kopioiTaulukko(int koko){
        int[] taulu = new int[koko];
        for (int i = 0; i < taulu.length && i < ljono.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
    
    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuloste = "{";
        for(int i=0;i<ljono.length && i < alkioidenLkm;i++){
            tuloste += ljono[i];
            if(alkioidenLkm - i > 1 ){
                tuloste += ", ";
            }
        }
      return tuloste += "}";
    }

    public int[] toIntArray() {
      return kopioiTaulukko(alkioidenLkm);  
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
       IntJoukko x = new IntJoukko();
       lisaaTaulukko(x,a);
       lisaaTaulukko(x,b);
        return x;
    }
    
    private static void lisaaTaulukko(IntJoukko target, IntJoukko source){
        int[] sourceTaulukko = source.toIntArray();
        for (int i = 0; i < sourceTaulukko.length; i++) {
            target.lisaa(sourceTaulukko[i]);
        }
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b){
        IntJoukko y = new IntJoukko();
        return vertaile(a,b,true);
    }
    
     public static IntJoukko erotus(IntJoukko a, IntJoukko b){
        IntJoukko y = new IntJoukko();
        return vertaile(a,b,false);
    }
     
    private static IntJoukko vertaile(IntJoukko a, IntJoukko b, boolean ehto){
        IntJoukko y = new IntJoukko();
        int[] sourceTaulukko = a.toIntArray();
        for(int i = 0;i < sourceTaulukko.length;i++){
            if (ehto == b.kuuluu(sourceTaulukko[i])){
                y.lisaa(sourceTaulukko[i]);
            }
        }
        return y;
    } 
    
}