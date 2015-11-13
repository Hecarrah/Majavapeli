package mpeli.gui;

import mpeli.entity.Hahmo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Pelilauta extends JPanel implements ActionListener {
    private Timer timer;
    private Hahmo h;
    
    public Pelilauta(){
        initBoard();
    }
    public int getTimer(){
       return  timer.getDelay();
    }
    private void initBoard(){
        addKeyListener(new Adapter());
        
        setFocusable(true);
        setBackground(Color.RED);
        setOpaque(true);
        
        h = new Hahmo("Timmy");
        
        timer = new Timer(10, this);
        timer.start();
    }
        @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponents(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(h.getImage(), h.getPosX(), h.getPosY(), this);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            h.liiku();
            repaint();  
    }
    
private class Adapter extends KeyAdapter {
    
    @Override
    public void keyReleased(KeyEvent e) {
        h.keyReleased(e);
    }
}
}
