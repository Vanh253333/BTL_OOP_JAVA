/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import pkg2dgamesframework.QueueList;


public class ChimneyGroup {
    
    private QueueList<Chimney> chimneys;
    
    private BufferedImage chimneyImage, chimneyImage2;
    private BufferedImage pipeGreenImg1, pipeGreenImg2, pipeGrayImg1, pipeGrayImg2, pipeRedImg1, pipeRedImg2;
    
    public static String selectPipe = "Green";
    
    public static int SIZE = 6;
    
    private int topChimneyY = -350;
    private int bottomChimneyY = 200;
    
    public Chimney getChimney(int i){
        return chimneys.get(i);
    }
    
    public int getRandomY(){
        Random random = new Random();
        int a;
        a = random.nextInt(10);
        
        return a*35;
    }
    
    public ChimneyGroup(){
        
        try {            
            pipeGreenImg1 = ImageIO.read(new File("Assets/INGAME/chimney.png"));
            pipeGreenImg2 = ImageIO.read(new File("Assets/INGAME/chimney2.png"));
            
            pipeGrayImg1 = ImageIO.read(new File("Assets/INGAME/pipegray1.png"));
            pipeGrayImg2 = ImageIO.read(new File("Assets/INGAME/pipegray2.png"));
            
            pipeRedImg1 = ImageIO.read(new File("Assets/INGAME/pipered1.png"));
            pipeRedImg2 = ImageIO.read(new File("Assets/INGAME/pipered2.png"));
            
        } catch (IOException ex) {}
        
        chimneys = new QueueList<Chimney>();
        
        Chimney cn;
        
        for(int i = 0; i< SIZE/2;i++){
            
            int deltaY = getRandomY();
            
            cn = new Chimney(830+i*300, bottomChimneyY + deltaY, 74, 400);
            chimneys.push(cn);
            
            cn = new Chimney(830+i*300, topChimneyY + deltaY, 74, 400);
            chimneys.push(cn);
        }
        
    }
    
    public void resetChimneys(){
        chimneys = new QueueList<Chimney>();
        
        Chimney cn;
        
        for(int i = 0; i< SIZE/2;i++){
            
            int deltaY = getRandomY();
            
            cn = new Chimney(830+i*300, bottomChimneyY + deltaY, 74, 400);
            chimneys.push(cn);
            
            cn = new Chimney(830+i*300, topChimneyY + deltaY, 74, 400);
            chimneys.push(cn);
        }
    }
    
    public int ok = 1;
    
    public void update(){
        boolean check = false;
        for(int i = 0;i < SIZE; i++){
            chimneys.get(i).update();
//            if(i%2==0){
//                if(chimneys.get(i).getPosY() > 150 && chimneys.get(i).getPosY() < 460){
//                    chimneys.get(i).setPosY(chimneys.get(i).getPosY()+1*ok);
//                    
//                    check = true;
//                }
//            }else{
//                if(check){
//                    chimneys.get(i).setPosY(chimneys.get(i).getPosY()+1*ok);
//                } 
//            }
        }   
        

        
        if(chimneys.get(0).getPosX()<-74) {
            
            int deltaY = getRandomY();
            
            Chimney cn;
            cn = chimneys.pop();
            cn.setPosX(chimneys.get(4).getPosX() + 300);
            cn.setPosY(bottomChimneyY + deltaY);
            cn.setIsBehindBird(false);
            chimneys.push(cn);
            
            cn = chimneys.pop();
            cn.setPosX(chimneys.get(4).getPosX());
            cn.setPosY(topChimneyY + deltaY);
            cn.setIsBehindBird(false);
            chimneys.push(cn);
        }
        
    }
    
    public void paint(Graphics2D g2){
        if(selectPipe.equals("Green")){
            chimneyImage = pipeGreenImg1;
            chimneyImage2 = pipeGreenImg2;
        }
        if(selectPipe.equals("Gray")){
            chimneyImage = pipeGrayImg1;
            chimneyImage2 = pipeGrayImg2;
        }
        if(selectPipe.equals("Red")){
            chimneyImage = pipeRedImg1;
            chimneyImage2 = pipeRedImg2;
        }
        
        for(int i = 0;i < 6; i++)
            if(i%2==0)
                g2.drawImage(chimneyImage, (int )chimneys.get(i).getPosX(), (int)chimneys.get(i).getPosY(), null);
            else g2.drawImage(chimneyImage2, (int )chimneys.get(i).getPosX(), (int)chimneys.get(i).getPosY(), null);
    }
}
