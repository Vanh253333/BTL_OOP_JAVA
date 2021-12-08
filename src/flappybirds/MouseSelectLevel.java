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
public class MouseSelectLevel implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my  = e.getY();
        if(FlappyBirds.State == FlappyBirds.STATE.SETTING){
            // level 1
            if(mx >= 155 && mx <= 250){
                if(my >= 265 && my <=370){
                    bird.gameClick.play();
                    FlappyBirds.kk = -4;
                    FlappyBirds.g = 0.1f;
                    FlappyBirds.State = FlappyBirds.STATE.MENU;
                }
            }
            //level 2
            if(mx >= 355 && mx <= 455){
                if(my >= 265 && my <=370){
                    bird.gameClick.play();
                    FlappyBirds.kk = -5;
                    FlappyBirds.g = 0.2f;
                    FlappyBirds.State = FlappyBirds.STATE.MENU;
                }
            }
            // level 3
            if(mx >= 545 && mx <= 640){
                if(my >= 265 && my <=370){
                    bird.gameClick.play();
                    FlappyBirds.kk = 3;
                    FlappyBirds.g = -0.1f;
                    FlappyBirds.State = FlappyBirds.STATE.MENU;
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
