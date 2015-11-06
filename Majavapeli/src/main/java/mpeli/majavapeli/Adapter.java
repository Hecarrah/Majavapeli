package mpeli.majavapeli;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Adapter extends KeyAdapter {
    
    @Override
    public void keyReleased(KeyEvent e) {
        Hahmo.keyReleased(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Hahmo.keyPressed(e);
    }
}
