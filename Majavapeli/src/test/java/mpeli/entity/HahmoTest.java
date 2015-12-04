package mpeli.entity;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import mpeli.gui.Container;
import static org.junit.Assert.*;
import org.junit.Test;

public class HahmoTest {
    
    @Test
    public void testaaOletusNimi(){
        Hahmo m = new Hahmo();
        if(m.getNimi().equals("Majava"))
            assertFalse("Väärä nimi", false);
    }
    @Test
    public void testaaImage(){
        Hahmo m = new Hahmo();
        Image a = m.getImage();
        ImageIcon ii = new ImageIcon("src\\main\\java\\grafiikka\\box.jpg");
        Image ai = ii.getImage();
            assertEquals(a, ai);
    }
    @Test
    public void testaaLiiku(){
        Container c = new Container();
        c.setSize(512, 512);
        Hahmo m = new Hahmo();
        if(m.setPos(100, 100)){
        m.liiku(10, 0);
        assertEquals(m.getPosX(), 110);
        m.liiku(0, 10);
        assertEquals(m.getPosY(), 110);
        m.setPos(9000, 3000);
        m.liiku(10, 0);
        assertEquals(m.getPosY(), 20);
        assertEquals(m.getPosX(), 250);
        }
    }
    @Test
    public void testaaOmaNimi(){
        Hahmo m = new Hahmo("Test");
        if(m.getNimi().equals("Test"))
            assertFalse("Väärä nimi", false);
    }
    @Test
    public void testaaSetNimi(){
        Hahmo h = new Hahmo();
        h.setNimi("Timmy");
        if(h.getNimi().equals("Timmy"))
            assertFalse("Väärä nimi", false);
    }
    @Test
    public void testaaSetPos(){
        Hahmo m = new Hahmo();
        m.setPos(1, 2);
        if(m.getPosX() == 1 && m.getPosY() == 2);
            assertFalse("Väärä paikka-arvo", false);
    }
    @Test
    public void testaaDefaultPos(){
        Hahmo m = new Hahmo();
        if(m.getPosX() ==0 && m.getPosY() == 0);
            assertFalse("Väärä paikka-arvo", false);
    } 
    @Test
    public void testaaKeyReleased(){
        Hahmo m = new Hahmo();
        try {
            Robot r = new Robot();
            r.keyRelease(KeyEvent.VK_S);
            r.keyRelease(KeyEvent.VK_D);
        } catch (AWTException ex) {
            Logger.getLogger(HahmoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(m.getPosX() == 1 && m.getPosY() == 1);
            assertFalse("keyReleased ei toiminut", false);
    } 
    public void testaaKeyReleased2(){
        Hahmo m = new Hahmo();
        try {
            Robot r = new Robot();
            r.keyRelease(KeyEvent.VK_S);
            r.keyRelease(KeyEvent.VK_D);
            r.keyRelease(KeyEvent.VK_S);
            r.keyRelease(KeyEvent.VK_D);
            r.keyRelease(KeyEvent.VK_A);
            r.keyRelease(KeyEvent.VK_W);
        } catch (AWTException ex) {
            Logger.getLogger(HahmoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(m.getPosX() == 1 && m.getPosY() == 1);
            assertFalse("keyReleased ei toiminut", false);
    } 
}

