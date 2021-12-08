/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author phamn
 */
public class Ground {
    
    private BufferedImage groundImage, groundGreenImage, groundRedImage, groundGrayImage;
    public static String selectGround = "Green";
    private int x1, y1, x2, y2;
    
    public Ground(){
        try {
            groundGreenImage = ImageIO.read(new File("Assets/INGAME/ground.png"));
            groundGrayImage = ImageIO.read(new File("Assets/INGAME/groundgray.png"));
            groundRedImage = ImageIO.read(new File("Assets/INGAME/groundred.png"));
        } catch (IOException ex) {}
        
        x1 = 0;
        y1 = 465;
        x2 = x1+830;
        y2 = 465;
    }
    
    public void Update(){
        x1-=2;
        x2-=2;
        
        if(x2 < 0) x1 = x2+830;
        if(x1 < 0) x2 = x1+830;
    }
    
    public void Paint(Graphics2D g2){
        if(selectGround.equals("Red")){
            groundImage = groundRedImage;
        }
        if(selectGround.equals("Gray")){
            groundImage = groundGrayImage;
        }
        if(selectGround.equals("Green")){
            groundImage = groundGreenImage;
        }
        g2.drawImage(groundImage, x1, y1, null);
        g2.drawImage(groundImage, x2, y2, null);
    }
    
    public int getYGround(){
        return y1;
    }
    
}
