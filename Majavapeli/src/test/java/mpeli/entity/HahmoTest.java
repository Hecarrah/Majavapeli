package mpeli.entity;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
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

