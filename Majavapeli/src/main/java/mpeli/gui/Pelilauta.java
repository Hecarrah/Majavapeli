package mpeli.gui;

import mpeli.entity.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * Pelilauta on se osa peliä joka huolehtii suurimmasta osasta pelin logiikasta.
 * @author Peter
 */
public class Pelilauta extends JPanel implements ActionListener {
    private Timer timer;
    private static Hahmo h;
    private static Pato p;
    private static Risu r;
    private static boolean risuKeratty = false;
    private static boolean rakennaPatoa = false;
    
    public Pelilauta(){
        initBoard();
    }
    public int getTimer(){
       return  timer.getDelay();
    }
    /**
     * InitBoard metodi huolehtii siitä että lauta alustetaan oikein, ja luo samalla padon, hahmon, ja risun luokkien esiintymät
     * metodi aloittaa myös timerin päivittämään JPanelin tietyin aikavälein jotta liikkuminen ruudulla olisi sujuvaa
     */
    private void initBoard(){
        addKeyListener(new Adapter());
        
        setFocusable(true);
        setOpaque(true);
        
        p = new Pato();
        r = new Risu();
        h = new Hahmo("Timmy");
        
        
        timer = new Timer(10, this);
        timer.start();
    }
    /**
     * paintComponent valmistelee ruudun doDrawing metodia varten jossa siinä voidaan piirrellä ruudulle Graphics2D metodin avulla
     * @param g 
     */
        @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponents(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }
    /**
     * doDrawing metodi on keskeinen osa graafista käyttöliittymää koska se käsittelee samalla myös risujen keräyksen ja padon rakentamisen.
     * Metodissa on if lausekkeet risuKeratty ja rakennaPatoa, jotka ovat boolean muuttujija. Jos jompikumpi on tosi niin se tarkoittaa että käyttäjä on liikuttanut majavan risun, tai padon päälle ja painanut välilyöntiä
     * @param g 
     */
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if(risuKeratty){
            risuKeratty = false;
            r.randomize();
        }
        if(rakennaPatoa){
            rakennaPatoa = false;
            g2d.setColor(Color.green);
            g2d.fillRect(p.getPosX(), p.getPosY(), 10, p.getProgress()*10);
        }
        g2d.drawImage(r.getImage(),r.getPosX(), r.getPosY(), this);
        g2d.setColor(Color.blue);
        g2d.fillRect(0, 150, 512, 200);
        g2d.drawImage(h.getImage(), h.getPosX(), h.getPosY(), this);
        g2d.setColor(Color.green);
        g2d.fillRect(p.getPosX(), p.getPosY(), 10, p.getProgress()*10+10);
        g2d.drawImage(p.getImage(), p.getPosX(), p.getPosY(), this);
    }
    /**
     * actionPerfomed huolehtii siitä että kun käyttäjä tekee jotain, niin liikutetaan majavaa, ja maalataan gui uusiksi.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
            h.liiku();
            repaint();  
    }
    /**
     * toiminta on metodi jota kutsutaan aina kun käyttäjä painaa välilyöntiä
     * Metodi tarkistaa onko majava risun tai padon päälläm, ja jos jompikumpi on tosi niin sitten muutetaan sopiva arvo true:ksi
     */
    public static void Toiminta(){
        if((h.getPosX() == r.getPosX()) && (h.getPosY() == r.getPosY())){
            System.out.println("risu");
            r.keratty();
            risuKeratty = true;
        }
        if((h.getPosX() == p.getPosX()) && (h.getPosY() == p.getPosY())){
            if(r.getMaara() > 0){
                if(p.getProgress() >= 10){
                    System.out.println("voitit pelin");
                }
                r.patoon();
            System.out.println("pato");
            p.rakenna();
            rakennaPatoa = true;
            }
        }
    }
    /**A
     * Adapter luokka on nimensä mukaan adapteri pelilaudan ja hahmon välillä
     * Adapter luokan avulla saadaan helposti välitettyä käskyt hahmo luokan käsiteltäviksi
     */
private class Adapter extends KeyAdapter {
    
    @Override
    public void keyReleased(KeyEvent e) {
        h.keyReleased(e);
    }
}
}
