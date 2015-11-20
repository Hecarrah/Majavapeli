package mpeli.entity;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class PatoTest {
        @Test
    public void testaaPato(){
        Pato p = new Pato();
        if(p.getPosX() == 50 && p.getPosY() == 150);
            assertFalse("konstruktorin alkupaikka on väärin", false);
    }
        @Test
    public void testaaPato2(){
        Pato p = new Pato();
        if(p.getTyyppi().equals("pato"));
            assertFalse("konstruktorin alkutyyppi on väärin", false);
    }
        @Test
    public void testaaAlkuProgress(){
        Pato p = new Pato();
        if(p.getProgress() == 0);
            assertFalse("padon progressi on väärin", false);
    }
        @Test
    public void testaaRakenna(){
        Pato p = new Pato();
        p.rakenna();
        if(p.getProgress() == 1);
            assertFalse("padon progressi on väärin", false);
    }
        @Test
    public void testaaSetPos(){
        Pato p = new Pato();
        p.setPos(10, 10);
        if(p.getPosX() == 10 && p.getPosY() == 10);
            assertFalse("pato on väärässä paikassa", false);
    }
}
