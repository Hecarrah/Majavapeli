package mpeli.gui;

import mpeli.entity.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
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
    private static Halko e;
    private static Halko e2;
    private static Halko e3;
    private static Halko e4;
    private static Halko e5;
    private static JLabel risumaara;
    private static boolean risuKeratty = false;
    private static boolean rakennaPatoa = false;
    private static boolean halolla = false;
    
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
        risumaara = new JLabel();
        addKeyListener(new Adapter());
        
        setFocusable(true);
        setOpaque(true);
        
        p = new Pato();
        r = new Risu();
        h = new Hahmo("Timmy");
        e = new Halko(); e.setPos(e.getPosX(), 150);
        e2 = new Halko(); e2.setPos(e.getPosX(), 190);
        e3 = new Halko(); e3.setPos(e.getPosX(), 230);
        e4 = new Halko(); e4.setPos(e.getPosX(), 270);
        e5 = new Halko(); e5.setPos(e.getPosX(), 310);
        e.setDx(10);
        e2.setDx(20);
        e3.setDx(15);
        e4.setDx(-10);
        e5.setDx(-20);
        this.add(risumaara);
        
        
        timer = new Timer(100, this);
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
        g2d.setColor(Color.green);
        g2d.fillRect(p.getPosX(), p.getPosY(), 10, p.getProgress()*10+10);
        g2d.drawImage(p.getImage(), p.getPosX(), p.getPosY(), this);
        
        g2d.drawImage(e.getImage(), e.getPosX(), e.getPosY(), this);
        g2d.drawImage(e2.getImage(), e2.getPosX(), e2.getPosY(), this);
        g2d.drawImage(e3.getImage(), e3.getPosX(), e3.getPosY(), this);
        g2d.drawImage(e4.getImage(), e4.getPosX(), e4.getPosY(), this);
        g2d.drawImage(e5.getImage(), e5.getPosX(), e5.getPosY(), this);
        g2d.drawImage(h.getImage(), h.getPosX(), h.getPosY(), this);
    }
    /**
     * actionPerfomed huolehtii siitä että kun käyttäjä tekee jotain, niin liikutetaan majavaa, ja maalataan gui uusiksi.
     * Ja tarkistetaan onko majava jonkin halon päällä, jos on niin ei liikuteta sitä halkoa
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
            h.liiku();
            if(!(h.getPosX() >= e.getPosX() && h.getPosX() <= e.getPosX()+30 && h.getPosY() >= e.getPosY()&& h.getPosY() <= e.getPosY()+30)){
            e.liiku();}
            if(!(h.getPosX() >= e2.getPosX() && h.getPosX() <= e2.getPosX()+30 && h.getPosY() >= e2.getPosY()&& h.getPosY() <= e2.getPosY()+30)){
            e2.liiku();}
            if(!(h.getPosX() >= e3.getPosX() && h.getPosX() <= e3.getPosX()+30 && h.getPosY() >= e3.getPosY()&& h.getPosY() <= e3.getPosY()+30)){
            e3.liiku();}
            if(!((h.getPosX() >= e4.getPosX() && h.getPosX() <= e4.getPosX()+30) && (h.getPosY() >= e4.getPosY()&& h.getPosY() <= e4.getPosY()+30))){
            e4.liiku();}
            if(!((h.getPosX() >= e5.getPosX() && h.getPosX() <= e5.getPosX()+30) && (h.getPosY() >= e5.getPosY()&& h.getPosY() <= e5.getPosY()+30))){
            e5.liiku();}
            repaint();  
            risumaara.setText(""+r.getMaara());
    } /**
     * tarkistetaan onko hahmo minkä tahansa halon päällä, jos on palautetaan true, jos ei niin sitten palautetaan false
     * @return 
     */
    public static boolean getHalolla(){
        if((h.getPosX() >= e.getPosX() && h.getPosX() <= e.getPosX()+30 && h.getPosY() >= e.getPosY()&& h.getPosY() <= e.getPosY()+30)){;
        return true;}
        else if((h.getPosX() >= e2.getPosX() && h.getPosX() <= e2.getPosX()+30 && h.getPosY() >= e2.getPosY()&& h.getPosY() <= e2.getPosY()+30)){;
        return true;}
        else if((h.getPosX() >= e3.getPosX() && h.getPosX() <= e3.getPosX()+30 && h.getPosY() >= e3.getPosY()&& h.getPosY() <= e3.getPosY()+30)){;
        return true;}
        else if((h.getPosX() >= e4.getPosX() && h.getPosX() <= e4.getPosX()+30 && h.getPosY() >= e4.getPosY()&& h.getPosY() <= e4.getPosY()+30)){;
        return true;}
        else if((h.getPosX() >= e5.getPosX() && h.getPosX() <= e5.getPosX()+30 && h.getPosY() >= e5.getPosY()&& h.getPosY() <= e5.getPosY()+30)){;
        return true;}
        
        else return false;
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
        if((h.getPosX() == 250) && (h.getPosY() == 0)){
            System.out.println("debug risu");
            r.keratty();
        }
        if((h.getPosX() == p.getPosX()) && (h.getPosY() == p.getPosY())){
            if(r.getMaara() > 0){
                if(p.getProgress() >= 19){
                    System.out.println("voitit pelin");
                }else{
                r.patoon();
                if(p.getProgress() == 18){
                    System.out.println("voitit pelin");
                }
            System.out.println("pato");
            p.rakenna();
            rakennaPatoa = true;
                }
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
