package mpeli.entity;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Random;
/**
 * risu luokka kuvaa risua joita pelaajan tulisi kerätä voittaakseen pelin.
 * @author Peter
 */
public class Risu extends Esine{
    /**
     * @param montako kuvaa sitä kuinka monta risua pelaajalla on hallussaan kullakin hetkellä.
     */
    int montako = 0;
    private Image image;
    
    /** 
     * konstruktorissa määritellään ensimmäisen risun sijainti, ja muutetaan esineen tyyppiä.
     */
    public Risu(){
        init();
        super.setPos(50, 50);
        super.change("Risu");
    }
    /**
     * kerätty metodissa nostetaan hallussa olevien risujen määrää yhdellä.
     */
    public void keratty(){
        montako++;
    }
    /** 
     * Randomize metodi antaa keräyksen jälkeen uudelle risulle uuden paikan, jotta pelaaja pääsee hakemaan uutta risua.
     */
    public boolean randomize(){
        Random r = new Random();
        boolean bo = r.nextBoolean();
        double x = Math.random()*50;
        double y = Math.random()*10;
        if(bo){

        int a = (int)x*10;
        int b = (int)y*10+350;
        super.setPos(a, b);
        return true;
        }else{
            
        int a = (int)x*10;
        int b = (int)y*10;
        super.setPos(a, b);
        return true;
        }
    }
    /**
     * patoon metodi toimii päinvastoin kun kerätty metodi, ja poistaa pelaajalta yhden risun.
     */
    public void patoon(){
        montako--;
    }
    public int getMaara(){
        return montako;
    }
    /**
     * init metodissa annetaan risulle kuva jota käytetään graafisessa liittymassa
     */
    public void init(){
        ImageIcon ii = new ImageIcon("src/main/java/grafiikka/pun.jpg");
        image = ii.getImage();
    }
        public Image getImage(){
        return image;
    }
}
