/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirds;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SETTING {
    
    private BufferedImage Level;
    
    public void render(Graphics g2){

        try {
            Level = ImageIO.read(new File("Assets/MENU/SelectButtons.png"));
            
            
        } catch (IOException ex) {}
        g2.drawImage(Level, 50, 50, null);// 520x480

        
        
    }

    
}
