package mpeli.entity;

public class Esine {
    private String tyyppi = "";
    private int posX = 0;
    private int posY = 0;
    
    public Esine(){
        init();
}
    public Esine(String t, int x, int y){
        tyyppi = t;
        posX = x;
        posY = y;           
        init();
}
    private void init(){
        
    }
    public String getTyyppi(){
        return tyyppi;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public void setPos(int x, int y){
        posX = x;
        posY = y;
    }
    public void remove(){
        //delete
    }
    public void change(String t){
        tyyppi = t;
    }
}
