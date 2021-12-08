/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import static flappybirds.FlappyBirds.bird;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author HP
 */
public class MouseSeclectMap2 implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

//            
//            g2.drawImage(groundRedImg, 465, 300, null);
//            g2.drawImage(groundGrayImg, 465, 400, null);
//            g2.drawImage(groundGreenImg, 465, 200, null);
        int mx = e.getX();
        int my  = e.getY();
        if(FlappyBirds.State == FlappyBirds.STATE.MAP_GROUNDPIPE){
            // next
            if(mx >= 15 && mx <= 55){
                if(my >= 300 && my <=360){
                    bird.gameClick.play();
                    FlappyBirds.State = FlappyBirds.STATE.MAP;
                }
            } 
            // pipe red 
            if(mx >= 115 && mx <= 170){
                if(my >= 230 && my <= 530){
                    bird.gameClick.play();
                    ChimneyGroup.selectPipe = "Red";
                }
            }   
            // pipe gray
            if(mx >= 220 && mx <= 275){
                if(my >= 230 && my <= 530){
                    bird.gameClick.play();
                    ChimneyGroup.selectPipe = "Gray";
                }
            }
            //pipe green
            if(mx >= 325 && mx <= 375){
                 if(my >= 230 && my <= 530){
                    bird.gameClick.play();
                    ChimneyGroup.selectPipe = "Green";
                }
            }
            
            // ground green
            if(mx >= 475 && mx <= 675){
                 if(my >= 230 && my <= 290){
                    bird.gameClick.play();
                    Ground.selectGround = "Green";
                }
            }
            // ground red
            if(mx >= 475 && mx <= 675){
                 if(my >= 330 && my <= 390){
                    bird.gameClick.play();
                    Ground.selectGround  = "Red";
                }
            }
            // ground gray
            if(mx >= 475 && mx <= 675){
                 if(my >= 430 && my <= 490){
                    bird.gameClick.play();
                    Ground.selectGround  = "Gray";
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
