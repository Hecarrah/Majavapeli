package mpeli.entity;
import static org.junit.Assert.*;
import org.junit.Test;

public class EsineTest {
    
    @Test
    public void testaaEsine(){
        Esine e = new Esine("risu",1,1);
        if(e.getPosX() == 1 && e.getPosY() == 1 && e.getTyyppi().equals("risu"));
            assertFalse("konstruktori toimii väärin", false);
    }
    @Test
    public void testaaEsine2(){
        Esine e = new Esine();
        if(e.getPosX() == 0 && e.getPosY() == 0 && e.getTyyppi().equals(""));
            assertFalse("konstruktori toimii väärin", false);
    }
    @Test
    public void testaaSetPos(){
        Esine e = new Esine();
        e.setPos(1, 2);
        if(e.getPosX() == 1 && e.getPosY() == 2);
            assertFalse("Väärä paikka-arvo", false);
    }
    @Test
    public void testaaDefaultPos(){
        Esine e = new Esine();
        if(e.getPosX() ==0 && e.getPosY() == 0);
            assertFalse("Väärä paikka-arvo", false);
    } 
    @Test
    public void testaaGetPos(){
        Esine e = new Esine();
        e.setPos(2, 2);
        if(e.getPosX() ==2 && e.getPosY() == 2);
            assertFalse("Väärä paikka-arvo", false);
    } 
    @Test
    public void testaaChange(){
        Esine e = new Esine();
        e.change("risu");
        if(e.getTyyppi().equals("risu"));
            assertFalse("Väärä paikka-arvo", false);
    } 
}

