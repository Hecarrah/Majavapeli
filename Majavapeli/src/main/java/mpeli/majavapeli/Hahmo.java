package mpeli.majavapeli;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class Hahmo extends JLabel{

    private String nimi = "Majava";
    private int x = 0;
    private int y = 0;
    
    public Hahmo(){
        this.nimi = "Majava";
        System.out.println("Nimi on: "+nimi);
    }
    public Hahmo(String oma){
        this.nimi = oma;
        System.out.println("Nimi on: "+nimi);
    }
    public String getNimi(){
        return this.nimi;
    }
    public int getPosX(){
        return this.x;
    }
    public int getPosY(){
        return this.y;
    }
    public boolean setPos(int a, int b){
        int x = a;
        int y = b;
        return true;
    }
    public void setNimi(String n){
        this.nimi = n;
    }
    public static void liiku(){
        
    }
    
    static void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(KeyEvent.VK_W == key){
            System.out.println("ylös");
        }
        if(KeyEvent.VK_S == key){
            System.out.println("alas");
        }
        if(KeyEvent.VK_A == key){
            System.out.println("vasen");
        }
        if(KeyEvent.VK_D == key){
            System.out.println("oikea");
        }
        if(KeyEvent.VK_SPACE == key){
            System.out.println("space");
        }
    }

    static void keyReleased(KeyEvent e) {
        
    }
}
