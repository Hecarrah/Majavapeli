package mpeli.majavapeli;

import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Pelilauta extends JFrame implements ActionListener {
    private Timer timer;
    
    public Pelilauta(){
        initBoard();
        
    }
    public int getTimer(){
       return  timer.getDelay();
    }
    
    private void initBoard(){
        JFrame lauta = new JFrame();
        lauta.setSize(100, 100);
        lauta.addKeyListener(new Adapter());
        lauta.setFocusable(true);
        Hahmo h = new Hahmo("Timmy");
        timer = new Timer(10, this);
        timer.start();
        lauta.add(h);
        lauta.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            Hahmo.liiku();
            repaint();
    }
}
