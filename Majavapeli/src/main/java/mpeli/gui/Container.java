package mpeli.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Container extends JFrame implements ActionListener {
    private Timer timer;
    public Container(){
        init();
    }
    private void init(){
        Pelilauta p = new Pelilauta(); 
        add(p);     
        setSize(512,512);
        setResizable(false);    
        setTitle("Majavapeli"); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setBackground(Color.black);
        timer = new Timer(10,this);
        timer.start();
        
    }
        public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                Container c = new Container();
                c.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    public boolean getTimer(){
        return timer.isRunning();
    }
}
