package mpeli.entity;

import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * Pato luokka kuvaa patoa, joka on pelin tavoitteena saada valmiiksi.
 * @author Peter
 */
public class Pato extends Esine {
/**
 * @param progress kuvaa sitä kuinka pitkälle valmis pato on tähän mennessä. Pelin voittaa kun pato ylittää joen.
 */
    int progress = 0;
    private Image image;

    /**
     * konstruktorissa määritetään padon sijainti, ja muutetaan esineen tyyppiä
    */
    public Pato() {
        init();
        super.setPos(50, 150);
        super.change("Pato");
    }
    /**
     * rakenna metodi kasvattaa padon edistymistä, eli progressia yhdellä
     */
    public void rakenna() {
        progress++;
    }
    public int getProgress() {
        return progress;

    }
    /**
     * init metodissa annetaan padolle kuva, josta pelaaja tietää minne pato tulisi rakentaa.
     */
    public void init() {
        ImageIcon ii = new ImageIcon(Pato.class.getResource("/vihrea.jpg"));
        image = ii.getImage();
    }
    public Image getImage() {
        return image;
    }

}
