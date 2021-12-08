/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;


import java.awt.Rectangle;
import java.io.File;
import pkg2dgamesframework.Objects;
import pkg2dgamesframework.SoundPlayer;


public class Bird extends Objects{
    
    public static float vt = 0;
    
    private boolean isFlying = false;

    private Rectangle rect;
    
    private boolean isLive = true;
    
    public SoundPlayer fall, flap, getPoint, gameClick;
    
    public Bird(int x, int y, int w, int h){
        super(x, y, w, h);  
        rect = new Rectangle(x, y, w, h);
        
        fall = new SoundPlayer(new File("Assets/INGAME/fall.wav"));
        flap = new SoundPlayer(new File("Assets/INGAME/fap.wav"));
        getPoint = new SoundPlayer(new File("Assets/INGAME/getpoint.wav"));
        gameClick = new SoundPlayer(new File("Assets/INGAME/gameClick.wav"));
    }
    
    public void setLive(boolean b){
        isLive = b;
    }
    
    public boolean getLive(){
        return isLive;
    }
    public Rectangle getRect(){
        return rect;
    }
    public void setVt(float vt){
        this.vt = vt;
        
    }    
    public void update(long deltaTime){
        
        vt+=FlappyBirds.g;
        
        this.setPosY(this.getPosY()+vt);
        this.rect.setLocation((int) this.getPosX(),(int) this.getPosY());
        
        if(vt < 0) isFlying = true;
        else isFlying = false;
        
    }      
    public boolean getIsFlying(){
        return isFlying;
    }
}
