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
public class MAP_GROUNDPIPE {
        private BufferedImage pipeRedImg, pipeGrayImg, pipeGreenImg;
        private BufferedImage groundRedImg, groundGrayImg, groundGreenImg;
        private BufferedImage nextImg, selectBirdImg;
        
    public void render(Graphics g2){        
        try {
            nextImg = ImageIO.read(new File("Assets/MENU/next - Copy.png"));
            selectBirdImg = ImageIO.read(new File("Assets/MENU/SelectButtonsBird.png"));
            
            pipeRedImg = ImageIO.read(new File("Assets/MENU/pipered1.png"));
            pipeGrayImg = ImageIO.read(new File("Assets/MENU/pipegray.png"));
            pipeGreenImg = ImageIO.read(new File("Assets/MENU/chimney.png"));
            
            groundRedImg = ImageIO.read(new File("Assets/MENU/groundred.png"));
            groundGrayImg = ImageIO.read(new File("Assets/MENU/groundgray.png"));
            groundGreenImg = ImageIO.read(new File("Assets/MENU/ground.png"));
        } catch (IOException ex) {}   
            g2.drawImage(pipeRedImg, 110, 200, null);
            g2.drawImage(pipeGrayImg, 215, 200, null);
            g2.drawImage(pipeGreenImg, 320, 200, null);
            
            g2.drawImage(groundRedImg, 465, 300, null);
            g2.drawImage(groundGrayImg, 465, 400, null);
            g2.drawImage(groundGreenImg, 465, 200, null);
            
            g2.drawImage(selectBirdImg, 170, 50, null); 
            g2.drawImage(nextImg, 10, 275, null);
    }
}
