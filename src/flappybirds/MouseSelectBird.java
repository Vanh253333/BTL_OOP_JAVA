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
public class MouseSelectBird implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my  = e.getY();
         // select bird
        if(FlappyBirds.State == FlappyBirds.STATE.MAP_BIRD){
            if(mx >= 125 && mx <= 265){
                if(my >= 280 && my <= 420){
                    bird.gameClick.play();
                    FlappyBirds.selectBird = "yelow";
                }
            }   
            if(mx >= 335 && mx <= 475){
                if(my >= 280 && my <=420){
                    bird.gameClick.play();
                    FlappyBirds.selectBird = "blue";
                }
            }
            
            if(mx >= 545 && mx <= 685){
                 if(my >= 280 && my <=420){
                    bird.gameClick.play();
                    FlappyBirds.selectBird = "red";
                }
            }    
            // next   
            if(mx >= 730 && mx <= 780){
                if(my >= 300 && my <=360){
                    bird.gameClick.play();
                    FlappyBirds.State = FlappyBirds.STATE.MAP;
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
