
package flappybirds;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class LoGo {
    
    private BufferedImage groundImagesmall;
//    private BufferedImage groundImagebig;
    
    private int x, y;
    
    public LoGo(){
        try {

            groundImagesmall = ImageIO.read(new File("Assets/INGAME/logo.png"));
        } catch (IOException ex) {}
        
        x = 0;
        y = 0;
        
    }
    
    
    public void Paint(Graphics2D g2){
        g2.drawImage(groundImagesmall, x, y, null);
    }
       

    
   
}


