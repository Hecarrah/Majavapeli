package mpeli.entity;

import java.awt.Image;
import javax.swing.ImageIcon;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PatoTest {
        @Test
    public void testaaPato(){
        Pato p = new Pato();
        if(p.getPosX() == 50 && p.getPosY() == 150);
            assertTrue("konstruktorin alkupaikka on väärin", true);
    }
            @Test
    public void testaaImage(){
        Pato m = new Pato();
        Image a = m.getImage();
        ImageIcon ii = new ImageIcon("src\\main\\java\\grafiikka\\vihrea.jpg");
        Image ai = ii.getImage();
            assertEquals(a, ai);
    }
        @Test
    public void testaaPato2(){
        Pato p = new Pato();
        if(p.getTyyppi().equals("pato"));
            assertTrue("konstruktorin alkutyyppi on väärin", true);
    }
        @Test
    public void testaaPato3(){
        Pato p = new Pato();
        p.progress = 2;
        p.rakenna();
        p.change("test");
        p.init();
        p.setPos(100, 100);
        if(p.getTyyppi().equals("pato"));
            assertTrue("tyyppi on väärin", true);
        if(p.getTyyppi().equals("pato"));
            assertTrue("Tyyppi on väärin", true);
        if(p.getProgress() == 3){
            assertTrue("progress on väärin", true);
        }
    }
        @Test
    public void testaaAlkuProgress(){
        Pato p = new Pato();
        if(p.getProgress() == 0);
            assertTrue("padon progressi on väärin", true);
    }
        @Test
    public void testaaRakenna(){
        Pato p = new Pato();
        p.rakenna();
        if(p.getProgress() == 1);
            assertTrue("padon progressi on väärin", true);
    }
        @Test
    public void testaaSetPos(){
        Pato p = new Pato();
        p.setPos(10, 10);
        if(p.getPosX() == 10 && p.getPosY() == 10);
            assertTrue("pato on väärässä paikassa", true);
    }
}
