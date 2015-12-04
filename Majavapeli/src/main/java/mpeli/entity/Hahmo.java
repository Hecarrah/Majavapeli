package mpeli.entity;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import mpeli.gui.Container;
import mpeli.gui.Pelilauta;
/**
 * Hahmo luokka on pelissä seikkailevaa majavaa ohjaava luokka. Luokka hallitsee majavan ulkonäön ja liikkumisen.
 * @author Peter
 */
public class Hahmo{

    private String nimi = "Majava";
    private static int posX = 250;
    private static int posY = 20;
    private Image image;
    /**
     * init Metodissa ladataan kuva majavalle.
     */
    private void init(){
        ImageIcon ii = new ImageIcon("src\\main\\java\\grafiikka\\box.jpg");
        image = ii.getImage();
    }
    /**
     * konstruktorissa määritetään majavan nimi ja tulostetaan se.
     */
    public Hahmo(){
        this.nimi = "Majava";
        System.out.println("Nimi on: "+nimi);
        init();
    }
    /**
     * Konstruktorissa määritetään majavan nimi ja tulostetaan se.
     * @param oma parametrilla voidaan syöttää majavalle oma vapa-avalintainen nimi.
     */
    public Hahmo(String oma){
        this.nimi = oma;
        System.out.println("Nimi on: "+nimi);
        init();
    }
    public String getNimi(){
        return this.nimi;
    }
    public Image getImage(){
        return image;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public boolean setPos(int a, int b){
        if(posX <= Container.getW() && 0 < posX){
        posX = a;
        }if(posY <= Container.getH() && 0 < posY){
        posY = b;
        }
        return true;
    }
    public void setNimi(String n){
        this.nimi = n;
    }
    /**
     * Liiku metodia kutsutaan aina kun halutaan saada majavaa liikkumaan johonkin suuntaan.
     * Kutsuissa vain toinen muuttujista on eri kuin 0, ja sen perusteella päätellään minneppäin liikutaan.
     * @param x on liikkumisen x koordinaatti
     * @param y on liikkumisen y koordinaatti
     */
    public void liiku(int x, int y){
        if((posY >= 150 && posY <= 300) && !Pelilauta.getHalolla()){
            System.out.println(Pelilauta.getHalolla());
            posX = 250;
            posY = 20;
        }
        else if (x != 0 && posX <= Container.getW() && 0 <= posX){
            posX += x;
        }else if(y != 0 && posY <= Container.getH() && 0 <= posY){
            posY += y;
        }else{
            posX = 250;
            posY = 20;
        }
    }
    /** 
     * parametritöntö liikkumista kutsutaan kun halutaan oikeasti liikuttaa majavaa näytöllä, eikä pelkästään siirtää sen paikkaa.
     */
    public void liiku(){
        
        this.setPos(posX, posY);

    }
    /**
     * keyReleased metodi huolehtii näppäimmistön tapahtumien hallinnasta. 
     * @param e parametri kertoo mitä näppäintä on painettu.
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(KeyEvent.VK_W == key){ //ylös
            liiku(0,-10);
        }
        if(KeyEvent.VK_S == key){ //alas
            liiku(0,10);
        }
        if(KeyEvent.VK_A == key){ //vasen
            liiku(-10,0);
        }
        if(KeyEvent.VK_D == key){ //oikea
            liiku(10,0);
        }
        if(KeyEvent.VK_SPACE == key){ //space
            Pelilauta.Toiminta();
        }
    }
}
