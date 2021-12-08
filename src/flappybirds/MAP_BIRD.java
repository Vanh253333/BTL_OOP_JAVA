/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author HP
 */
public class MAP_BIRD {
    private BufferedImage birdRedImg, birdBlueImg, birdYelowImg, selectBirdImg, nextImg ;
    public void render(Graphics g2){        
        try {
            nextImg = ImageIO.read(new File("Assets/MENU/next.png"));
            selectBirdImg = ImageIO.read(new File("Assets/MENU/SelectBird.png"));
            birdYelowImg = ImageIO.read(new File("Assets/MENU/bird - Copy (2).png"));
            birdBlueImg = ImageIO.read(new File("Assets/MENU/bird - Copy (3).png"));
            birdRedImg = ImageIO.read(new File("Assets/MENU/bird - Copy.png"));
 

        } catch (IOException ex) {}   
            g2.drawImage(birdRedImg, 540, 250, null); 
            g2.drawImage(birdBlueImg, 330, 250, null); 
            g2.drawImage(birdYelowImg, 120, 250, null); 
            g2.drawImage(selectBirdImg, 170, 50, null); 
            g2.drawImage(nextImg, 725, 275, null); 
    }
}
