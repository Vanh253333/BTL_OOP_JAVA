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
public class MouseSelectMap implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my  = e.getY();
        if(FlappyBirds.State == FlappyBirds.STATE.MAP){
            // map 1
            if(mx >= 185 && mx <= 325){
                if(my >= 230 && my <=330){
                    bird.gameClick.play();
                    FlappyBirds.chon = 1;
                }
            }
            // map 2
            if(mx >= 495 && mx <= 635){
                if(my >= 230 && my <= 330 ){
                    bird.gameClick.play();
                    FlappyBirds.chon = 2;
                }
            }
            // map 3
            if(mx >= 185 && mx <= 325){
                if(my >= 430 && my <= 530 ){
                    bird.gameClick.play();
                    FlappyBirds.chon = 3;
                    
                }
            }
            //map 4
            if(mx >= 495 && mx <= 635){
                if(my >= 430 && my <= 530 ){
                    bird.gameClick.play();
                    FlappyBirds.chon = 4;
                }
            }
            // next
            if(mx >= 15 && mx <= 55){
                if(my >= 305 && my <=360){
                    bird.gameClick.play();
                    FlappyBirds.State = FlappyBirds.STATE.MAP_BIRD;
                }
            } 
            // next 2
            if(mx >= 730 && mx <= 780){
                if(my >= 300 && my <=360){
                    bird.gameClick.play();
                    FlappyBirds.State = FlappyBirds.STATE.MAP_GROUNDPIPE;
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
