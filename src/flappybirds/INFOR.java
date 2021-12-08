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


/**
 *
 * @author Khong Duy Tuan
 */
public class INFOR {
    private BufferedImage MemberImage;
    public void render(Graphics g2){        
        try {
            MemberImage = ImageIO.read(new File("Assets/MENU/Member.png"));
        } catch (IOException ex) {}        
        g2.drawImage(MemberImage, 150, 30, null);// 500x479

    }
}
