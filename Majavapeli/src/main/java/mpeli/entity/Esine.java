package mpeli.entity;
/**
 * Esine luokka on yläluokka risulle ja padolle, joka tarjoaa kyseisille luokille muunmoassa paikka-arvot joita molemmat niistä käyttää.
 * @author Peter
 */
public class Esine {
    private String tyyppi = "";
    private int posX;
    private int posY;

/**
 * Parametritön konstruktori asettaa vain esineen sijainnin
 */
    public Esine(){
        posX = 0;
        posY = 0;
    }
    /**
     * Parametrillisessä konstruktorissa annetaan esineen tyyppi, ja paikka-arvo.
     */
    public Esine(String t, int x, int y){
        tyyppi = t;
        posX = x;
        posY = y;           
    }
    public String getTyyppi(){
        return tyyppi;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    /**
     * asettaa esineen sijainnin
     * @param x esineen x koordinaatti
     * @param y esineen y koordinaatti
     */
    public void setPos(int x, int y){
        posX = x;
        posY = y;
    }
    /**
     * change metodi muuttaa esineen tyyppiä
     * @param t on esineen uusi tyyppi
     */
    public void change(String t){
        tyyppi = t;
    }
}
