package mpeli.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
 /**
  * Container on graafisen käyttöliittymän ulkokuori. Luokka toimii pelin pääluokkana.
  * @author Peter
  */
public class Container extends JFrame implements ActionListener {
    private static int sY = 0;
    private static int sX = 0;
    
    private Timer timer;
    public Container(){
        init();
    }
    /**
     * Init:issä luodaan containerin sisälle itse pelilauta joka huolehtii pelin kulusta, ja valmistellaan container pelin toimintaa varten asettamalla peliruudun koko ja lukitsemalla se.
     * Init:issä aloitetaan myös timer joka pitää osaltaan huolen että ruutu pysyy päivittyneenä
     */
    private void init(){
        Pelilauta p = new Pelilauta(); 
        add(p);    
        sY = 512;
        sX = 512;
        setSize(sX, sY);
        setResizable(false);    
        setTitle("Majavapeli"); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setBackground(Color.black);
        timer = new Timer(10,this);
        timer.start();
        
    } /**
     * Pelin main metodi joka aloittaa pelin toiminnan.
     * Metodi myös asettaa itse containerin näkyväksi sen jälkeen kun kaikki siihe tarvittavat muut toimenpiteet ovat suoritettu.
     * @param args 
     */
        public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                Container c = new Container();
                c.setVisible(true);
            }
        });
    }
        public static int getH(){
            return sY;
        }
        public static int getW(){
            return sX;
        }
/**
 * actionPerformed metodi huolehtii siitä että kun käyttäjä painaa mitä tahansa nappia, tai ylipäänsä tekee mitään, niin ruutu päivittää itsensä.
 * @param e actionPerformed metodin vaatima parametri jota ei kuitenkaan käytetä tässä
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    public boolean getTimer(){
        return timer.isRunning();
    }
}
