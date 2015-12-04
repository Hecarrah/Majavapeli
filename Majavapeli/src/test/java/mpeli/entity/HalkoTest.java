package mpeli.entity;

import java.awt.Image;
import javax.swing.ImageIcon;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
/**
 * @author Peter
 */
public class HalkoTest {
        @Test
    public void testaaHalko(){
        Halko h = new Halko();
        if(h.getPosX() == 200 && h.getPosY() == 150);
            assertFalse("konstruktorin alkupaikka on väärin", false);
    }
        @Test
    public void testaaImage(){
        Halko m = new Halko();
        Image a = m.getImage();
        ImageIcon ii = new ImageIcon("src\\main\\java\\grafiikka\\halko.jpg");
        Image ai = ii.getImage();
            assertEquals(a, ai);
    }
    @Test
    public void testaaGetDx(){
        Halko h = new Halko();
        if(h.getDx() == 0);
            assertFalse("getDx oletusarvo on väärin tai getDx toimii väärin", false);
    }
    @Test
    public void testaaSetDx(){
        Halko h = new Halko();
        h.setDx(10);
        if(h.getDx() == 10);
            assertFalse("setDx tai getDx toimii väärin", false);
    }
    @Test
    public void testaaLiiku(){
        Halko h = new Halko();
        h.setDx(10);
        h.liiku();
        assertEquals(h.getPosX(), 210);
    }
    @Test
    public void testaaLiiku2(){
        Halko h = new Halko();
        h.setPos(510, 0);
        h.setDx(50);
        h.liiku();
        h.liiku();
            assertEquals(h.getPosX(), 40);
            assertEquals(h.getPosY(), 0);
    }
}
