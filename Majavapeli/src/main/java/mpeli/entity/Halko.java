package mpeli.entity;

import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * Halko luokka kuvaa halkoa jonka avulla majava pääsee 'froggeroimaan' joen yli. Eli pomppimaan halkojen yli.
 * Halot liikkuvat vaakasuuntaisesti joessa.
 * @author Peter
 */
public class Halko extends Esine {
    private Image image;
    private int dx = 0;
    
    /**
     * konstruktorissa asetetaan halon paikka, muutetaan tyyppi, ja kutsutaan init();
     */
    public Halko(){
        init();
        super.setPos(200, 150);
        super.change("Halko");
    }
    /**
     * init metodissa annetaan ja alustetaan kuva halkoa varten.
     * Halko.class.getResource() kutsulla saadaan halon kuva toimimaan myös jar tiedostossa.
     */
        public void init(){
        ImageIcon ii = new ImageIcon(Halko.class.getResource("/halko.jpg"));
        image = ii.getImage();
    }
        public Image getImage(){
        return image;
    }
        public void setDx(int x){
            dx = x;
        }
        public int getDx(){
            return dx;
        }
        /**
         * päivitetään halon sijainti.
         */
        public void liiku(){
            if(super.getPosX() < -10){
                super.setPos(512,super.getPosY());
            }if(super.getPosX() > 512){
                super.setPos(-10, super.getPosY());
            }
            super.setPos(super.getPosX() +dx, super.getPosY());
        }
}

