/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirds;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;


public class MAP {
    private BufferedImage selectBirdImg, nextImg, bg1Img, bg2Img, bg3Img, bg4Img, next2Img;
   
    public void Paint(Graphics2D g2){
        try {
            selectBirdImg = ImageIO.read(new File("Assets/MENU/SelectButtonsBird.png"));
            nextImg = ImageIO.read(new File("Assets/MENU/next - Copy.png"));
            bg1Img = ImageIO.read(new File("Assets/INGAME/bg1 - Copy.jpg"));
            bg2Img = ImageIO.read(new File("Assets/INGAME/bg2 - Copy.png"));
            bg3Img = ImageIO.read(new File("Assets/INGAME/bg3 - Copy.jpg"));
            bg4Img = ImageIO.read(new File("Assets/INGAME/bg4 - Copy.png"));
            next2Img = ImageIO.read(new File("Assets/MENU/next.png"));
            
 
        } catch (IOException ex) {}
        
            g2.drawImage(selectBirdImg, 170, 50, null);
            g2.drawImage(nextImg, 10, 275, null);
            g2.drawImage(bg1Img, 175, 200, null);
            g2.drawImage(bg2Img, 485, 200, null);
            g2.drawImage(bg3Img, 175, 400, null);
            g2.drawImage(bg4Img, 485, 400, null);
            g2.drawImage(next2Img, 725, 275, null); 
    }

}
