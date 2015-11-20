package mpeli.entity;

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
        p.randomize();
        if(p.getPosX() != x);
            assertFalse("satunnaispaikka on väärin", false);
    }
}
