
package flappybirds;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class BackGround {
    private BufferedImage backImage;
    private BufferedImage groundImage;
    private BufferedImage groundImage2, groundImage3, groundImage4;
    
    private int x1, y1, x2, y2;
    
    public BackGround(){
        try {
            backImage = ImageIO.read(new File("Assets/INGAME/rsz_background11111.png"));
            groundImage = ImageIO.read(new File("Assets/INGAME/bg1.jpg"));
            groundImage2 = ImageIO.read(new File("Assets/INGAME/bg2.png"));
            groundImage3 = ImageIO.read(new File("Assets/INGAME/bg3.jpg"));
            groundImage4 = ImageIO.read(new File("Assets/INGAME/bg4.png"));
           
        } catch (IOException ex) {}
        
        x1 = 0;
        y1 = 0;
        x2 = x1+830;
        y2 = 0;
    }
    
    public void Update(){
        x1-=2;
        x2-=2;
        
        if(x2 < 0) x1 = x2+830;
        if(x1 < 0) x2 = x1+830;
    }
    
    public void Paint(Graphics2D g2){
        g2.drawImage(backImage, x1, y1, null);
        g2.drawImage(backImage, x2, y2, null);
    }   
    
    public void Paint1(Graphics2D g2){
        g2.drawImage(groundImage, x1, y1, null);
        g2.drawImage(groundImage, x2, y2, null);
    }
    
    public void Paint2(Graphics2D g2){
        g2.drawImage(groundImage2, x1, y1, null);
        g2.drawImage(groundImage2, x2, y2, null);
    }
    
    public void Paint3(Graphics2D g2){
        g2.drawImage(groundImage3, x1, y1, null);
        g2.drawImage(groundImage3, x2, y2, null);
    }
    
    public void Paint4(Graphics2D g2){
        g2.drawImage(groundImage4, x1, y1, null);
        g2.drawImage(groundImage4, x2, y2, null);
    }
}

