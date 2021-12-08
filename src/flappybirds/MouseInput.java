/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappybirds;

import static flappybirds.FlappyBirds.bird;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Khong Duy Tuan
 */
public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
    }
   
    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my  = e.getY();
        if(FlappyBirds.State == FlappyBirds.STATE.MENU){
            // play
            if(mx >= 190 && mx <= 330){
                if(my >= 235 && my <= 305){
                    bird.gameClick.play();
                    FlappyBirds.State = FlappyBirds.STATE.GAME;
                }
            }
            
            // infor
            if(mx >= 250 && mx <= 560){
                if(my >= 450 && my <= 525){
                    bird.gameClick.play();
                    FlappyBirds.State = FlappyBirds.STATE.INFOR;
                }
            }
            
            //Quit
            if(mx >= 490 && mx <= 620){
                if(my >= 345 && my <= 415){
                    bird.gameClick.play();
                    System.exit(1);
                }
            }
            
            // setting == level
            if(mx >= 430 && mx <= 620 ){
                if(my >= 235 && my <= 305 ){
                    bird.gameClick.play();
                    FlappyBirds.State = FlappyBirds.STATE.SETTING;
                }
            }
            
            // options
            if(mx >= 190 && mx <= 395 ){
                if(my >= 345 && my <= 415 ){
                    bird.gameClick.play();
                    FlappyBirds.State = FlappyBirds.STATE.MAP_BIRD;
                }
            }
        }
        
        // nút home
        if(FlappyBirds.State != FlappyBirds.STATE.MENU){
            if(mx >= 20 && mx <= 72){
                if(my >= 530 && my <= 575){
                    bird.gameClick.play();
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
