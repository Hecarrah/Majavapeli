package mpeli.entity;

import java.awt.Image;
import javax.swing.ImageIcon;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class RisuTest {
           
    @Test
    public void testaaRisu(){
        Risu p = new Risu();
        if(p.getPosX() == 50 && p.getPosY() == 50);
            assertFalse("konstruktorin alkupaikka on väärin", false);
    }
            @Test
    public void testaaImage(){
        Risu m = new Risu();
        Image a = m.getImage();
        ImageIcon ii = new ImageIcon("src\\main\\java\\grafiikka\\pun.jpg");
        Image ai = ii.getImage();
            assertEquals(a, ai);
    }
    @Test
    public void testaaAlkuGetMaara(){
        Risu p = new Risu();
        if(p.getMaara() == 0);
            assertFalse("alkumäärä on väärin", false);
    }
    @Test
    public void testaaKeratty(){
        Risu p = new Risu();
        p.keratty();
        if(p.getMaara() == 1);
            assertFalse("määrä on väärin", false);
    }
    @Test
    public void testaaPatoon(){
        Risu p = new Risu();
        p.keratty();
        p.keratty();
        p.patoon();
        if(p.getMaara() == 1);
            assertFalse("määrä on väärin", false);
    }
    @Test
    public void testaaRandomize(){
        Risu p = new Risu();
        int x = p.getPosX();
        if(p.getPosX() != x && p.randomize());
            assertFalse("randomize väärin", false);
    }
}
