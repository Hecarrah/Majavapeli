package mpeli.gui;
import static org.junit.Assert.*;
import org.junit.Test;

public class PelilautaTest {
    
    @Test
    public void testaaNakyvyys(){
        Pelilauta p = new Pelilauta();
        if(p.isVisible())
            assertTrue("Lauta väärässä tilassa", true);
    }
    @Test
    public void focusable(){
        Pelilauta p = new Pelilauta();
        if(p.isFocusable())
            assertFalse("Lauta ei ole focusable", false);
    }
    @Test
    public void testTimer(){
        Pelilauta p = new Pelilauta();
        if(p.getTimer() == 10){
            assertFalse("timer on väärin", false);
        }
    }
}
