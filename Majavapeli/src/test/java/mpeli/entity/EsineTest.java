package mpeli.entity;
import static org.junit.Assert.*;
import org.junit.Test;

public class EsineTest {
    
    @Test
    public void testaaEsine(){
        Esine e = new Esine("risu",1,1);
        if(e.getPosX() == 1 && e.getPosY() == 1);
            assertTrue("konstruktori toimii väärin", true);
            assertEquals(e.getTyyppi(), "risu");
    }
    @Test
    public void testaaSetPos(){
        Esine e = new Esine();
        e.setPos(1, 2);
        if(e.getPosX() != 1 && e.getPosY() != 2){
            assertTrue("Väärä paikka-arvo", true);}
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
        assertEquals(e.getTyyppi(), "risu");
}
}

