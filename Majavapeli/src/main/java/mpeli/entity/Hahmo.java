package mpeli.entity;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Hahmo{

    private String nimi = "Majava";
    private static int posX = 10;
    private static int posY = 10;
    private Image image;
    
    private void init(){
        ImageIcon ii = new ImageIcon("src\\main\\java\\grafiikka\\box.jpg");
        image = ii.getImage();
    }
    
    public Hahmo(){
        this.nimi = "Majava";
        System.out.println("Nimi on: "+nimi);
        init();
    }
    public Hahmo(String oma){
        this.nimi = oma;
        System.out.println("Nimi on: "+nimi);
        init();
    }
    public String getNimi(){
        return this.nimi;
    }
    public Image getImage(){
        return image;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public boolean setPos(int a, int b){
        int x = a;
        int y = b;
        return true;
    }
    public void setNimi(String n){
        this.nimi = n;
    }
    public void liiku(int x, int y){
        if (x != 0){
            posX += x;
        }if(y != 0){
            posY += y;
        }
    }
    public void liiku(){
        this.setPos(posX, posY);

    }
    public void toiminta(){
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if(KeyEvent.VK_W == key){ //ylös
            liiku(0,-10);
        }
        if(KeyEvent.VK_S == key){ //alas
            liiku(0,10);
        }
        if(KeyEvent.VK_A == key){ //vasen
            liiku(-10,0);
        }
        if(KeyEvent.VK_D == key){ //oikea
            liiku(10,0);
        }
        if(KeyEvent.VK_SPACE == key){ //space
            toiminta();
        }
    }
}
