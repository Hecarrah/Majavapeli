package mpeli.entity;
/**
 * Esine luokka on yläluokka risulle ja padolle, joka tarjoaa kyseisille luokille muunmoassa paikka-arvot joita molemmat niistä käyttää.
 * @author Peter
 */
public class Esine {
    private String tyyppi = "";
    private int posX = 0;
    private int posY = 0;

    /**
     * Konstruktorissa annetaan esineen tyyppi, ja paikka-arvo.
     */
    public Esine(){
        init();
    }
    public Esine(String t, int x, int y){
        tyyppi = t;
        posX = x;
        posY = y;           
    }
    public void init(){
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
