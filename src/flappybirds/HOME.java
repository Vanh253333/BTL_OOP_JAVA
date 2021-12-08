package flappybirds;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class HOME {
    
    private BufferedImage menuImage;
    public void Paint(Graphics g2){
        try {
            menuImage = ImageIO.read(new File("Assets/MENU/home.png"));
        } catch (IOException ex) { 
        }
        g2.drawImage(menuImage, 15, 500, null);
        
        
    }
}
