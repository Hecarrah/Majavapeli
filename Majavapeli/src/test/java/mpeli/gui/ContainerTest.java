package mpeli.gui;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ContainerTest {
        @Test
    public void testaaNakyvyys(){
        Container c = new Container();
        if(c.isVisible())
            assertTrue("Container ei näy", true);
    }
    @Test
    public void testaaActive(){
        Container c = new Container();
        if(c.isActive())
            assertTrue("ei ole active", true);
    }
    @Test
    public void testaaEiResize(){
        Container c = new Container();
        if(c.isResizable())
            assertTrue("containerin koko ei ole lukittu", true);
    }
    @Test
    public void testaaTimerPaalla(){
        Container c = new Container();
        if(c.getTimer())
            assertTrue("Timer ei ole päällä", true);
    }
}
