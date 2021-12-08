/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirds;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class MENU {
    private BufferedImage MenuImage;
    public void render(Graphics g2){        
        try {
            MenuImage = ImageIO.read(new File("Assets/MENU/MenuButtons xxxx.png"));
        } catch (IOException ex) {}        
        g2.drawImage(MenuImage, 140, 40, null); 

    }
    
}
