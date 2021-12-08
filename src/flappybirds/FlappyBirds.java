/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import pkg2dgamesframework.AFrameOnImage;
import pkg2dgamesframework.Animation;
import pkg2dgamesframework.GameScreen;


public class FlappyBirds extends GameScreen{

    public static BufferedImage birdRedImg, birdBlueImg, birdYLImg, birdsImg;
    public static Animation bird_anim;
    private BufferedImage pressImg, pressClickImg, scoreImg, gameOverImg, gameReadyImg;
    
    public static float g = 0.1f;
    public static int kk = -3;
    // bien lua chon map
    public static int chon = 2;
    public static String selectBird = "yelow";
    
    public static Bird bird;
    private Ground ground;
    private LoGo logo;
    private ChimneyGroup chimneyGroup;
    private BackGround background;
    
    
    public static STATE State = STATE.MENU; 
    
    private MENU menu;
    private INFOR infor; 
    private SETTING setting;
    private MAP map;
    private HOME home;
    private MAP_BIRD mapBird;
    private MAP_GROUNDPIPE mapGroundPipe;
    
    private int Point = 0;
    private String hightPoint = "";
    
    private int BEGIN_SCREEN = 0;
    private int GAMEPLAY_SCREEN = 1;
    private int GAMEOVER_SCREEN = 2;
    private int CurrentScreen = BEGIN_SCREEN;
    
    public static enum STATE{
      MENU,// gồm INFOR, SETTING, MAP, HOME
      GAME,// play 
      INFOR, 
      SETTING, 
      MAP,
      MAP_BIRD,
      MAP_GROUNDPIPE,
      HOME //GAME, INFOR, MAP, SETTING -- chỉ cần vô hiệu hóa lúc ở MENU 
      
    };
    public FlappyBirds(){
        super(800,600);       
        try {
            birdRedImg = ImageIO.read(new File("Assets/INGAME/birdRed.png"));
            birdBlueImg = ImageIO.read(new File("Assets/INGAME/birdBlue.png"));
            birdYLImg = ImageIO.read(new File("Assets/INGAME/birdYL.png"));
        } catch (IOException ex) {}
        
        bird_anim = new Animation(70);
        AFrameOnImage f;
        f = new AFrameOnImage(0,0,60,60);
        bird_anim.AddFrame(f);
        f = new AFrameOnImage(60,0,60,60);
        bird_anim.AddFrame(f);
        f = new AFrameOnImage(120,0,60,60);
        bird_anim.AddFrame(f);
        f = new AFrameOnImage(60,0,60,60);
        bird_anim.AddFrame(f);
        
        bird = new Bird(350, 250, 50, 50);
        
        this.addMouseListener(new MouseInput());
        this.addMouseListener(new MouseSelectMap());
        this.addMouseListener(new MouseSelectLevel());
        this.addMouseListener(new MouseSelectBird());
        this.addMouseListener(new MouseSeclectMap2());
        ground = new Ground();
        menu = new MENU();
        infor = new INFOR();
        setting = new SETTING();
        home = new HOME();
        chimneyGroup = new ChimneyGroup();
        logo = new LoGo();
        map = new MAP();
        background = new BackGround();
        mapBird = new MAP_BIRD();
        mapGroundPipe = new MAP_GROUNDPIPE();
        BeginGame();
    }
    
    
    public static void main(String[] args) {
        new FlappyBirds();        
    }
    
    private void resetGame(){
        bird.setPos(350, 250);
        bird.setVt(0);
        bird.setLive(true);
        Point = 0;
        chimneyGroup.resetChimneys();
    }
    
    @Override
    public void GAME_UPDATE(long deltaTime) {
        
        if(State == STATE.GAME){
            
            if(CurrentScreen == BEGIN_SCREEN){
                resetGame();
            }else if(CurrentScreen == GAMEPLAY_SCREEN){

                if(bird.getLive()) bird_anim.Update_Me(deltaTime);
                bird.update(deltaTime);
                ground.Update();
                chimneyGroup.update();
                background.Update();               

                for(int i = 0;i<ChimneyGroup.SIZE;i++){
                    if(bird.getRect().intersects(chimneyGroup.getChimney(i).getRect())){
                        if(bird.getLive()) bird.fall.play();
                        bird.setLive(false);
                    }
                }

                for(int i = 0;i<ChimneyGroup.SIZE;i++){
                    if(bird.getPosX() > chimneyGroup.getChimney(i).getPosX() && !chimneyGroup.getChimney(i).getIsBehindBird()
                            && i%2==0 ){
                        if(bird.getLive() == true){
                            Point++;
                            bird.getPoint.play();
                            
                        }
                        chimneyGroup.getChimney(i).setIsBehindBird(true);
                    }

                }

                if(bird.getPosY() + bird.getH() > ground.getYGround()) {
                    bird.fall.play();
                    CurrentScreen = GAMEOVER_SCREEN;
                }
                if(bird.getPosY() < 0){
                    bird.fall.play();
                    CurrentScreen = GAMEOVER_SCREEN;
                }
            }
        
        }
        
    }

    @Override
    public void GAME_PAINT(Graphics2D g2) {       
        birdsImg = birdYLImg;       
        if(State == STATE.GAME){
            if(chon == 1){
                background.Paint1(g2);
            }
            if(chon == 2){
                background.Paint2(g2);
            }
            if(chon == 3){
                background.Paint3(g2);
            }
            if(chon == 4){
                background.Paint4(g2);
            }
                        
            if(selectBird.equals("yelow")){
                birdsImg = birdYLImg;
            }
            else if(selectBird.equals("blue")){
                birdsImg = birdBlueImg;
            }
            else{
                birdsImg = birdRedImg;
            }
            
            logo.Paint(g2);
            chimneyGroup.paint(g2);
            ground.Paint(g2);
            home.Paint(g2);
            // hight score
            if(hightPoint.equals("")){
                // init hightpoint
                hightPoint = this.getHightPoint();
            }

            if(bird.getIsFlying())
                bird_anim.PaintAnims((int) bird.getPosX(), (int) bird.getPosY(), birdsImg, g2, 0, -1);
            else 
                bird_anim.PaintAnims((int) bird.getPosX(), (int) bird.getPosY(), birdsImg, g2, 0, 0);

            if(CurrentScreen == BEGIN_SCREEN){
                  try {     
                    gameReadyImg = ImageIO.read(new File("Assets/INGAME/get ready.png"));
                    pressImg = ImageIO.read(new File("Assets/INGAME/pixel-speech-bubble.png"));
                    g2.drawImage(gameReadyImg, 250, 125, null);
                    g2.drawImage(pressImg, 250, 350, null);
                  } catch (IOException ex) {}
            }
            if(CurrentScreen == GAMEOVER_SCREEN){
                try {   
                    try {
                        checkPoint();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    
                    gameOverImg = ImageIO.read(new File("Assets/INGAME/gameover.png"));
                    scoreImg = ImageIO.read(new File("Assets/INGAME/score.png"));
                    pressClickImg = ImageIO.read(new File("Assets/INGAME/pixel-speech-bubble (1).png"));
                    g2.drawImage(gameOverImg, 250, 50, null);
                    g2.drawImage(scoreImg, 150, 150, null);
                    g2.drawImage(pressClickImg, 50, 485, null);
                    
                    g2.setColor(Color.black);
                    g2.setFont(new Font("Cooper Black", Font.PLAIN, 30));// set fornt cho chữ
                    g2.drawString(""+Point, 545, 250);
                    g2.setColor(Color.white);
                    g2.drawString(""+Point, 546, 251);
                    
                    g2.setColor(Color.black);
                    g2.drawString(""+hightPoint, 465, 350);
                    g2.setColor(Color.white);
                    g2.drawString(""+hightPoint, 466, 351);
                  } catch (IOException ex) {}
            }

            g2.setColor(Color.black);
            g2.setFont(new Font("Cooper Black", Font.PLAIN, 30));// set fornt cho chữ
            g2.drawString("Score: "+Point, 14, 54);
            g2.setColor(Color.white);
            g2.drawString("Score: "+Point, 15, 55);
        }
        if(State == STATE.MENU){
            background.Paint(g2);
            menu.render(g2);
                       
        }
        else if(State == STATE.INFOR){
            background.Paint(g2);
            infor.render(g2);
            home.Paint(g2);
        }
        if(State == STATE.SETTING){
            background.Paint(g2);
            home.Paint(g2);
            setting.render(g2);
            
        }
        if(State == STATE.MAP){
            background.Paint(g2);
            home.Paint(g2);
            map.Paint(g2);            
        }
        if(State == STATE.MAP_BIRD){
            background.Paint(g2);
            home.Paint(g2);
            mapBird.render(g2);            
        }
        if(State == STATE.MAP_GROUNDPIPE){
            background.Paint(g2);
            home.Paint(g2);
            mapGroundPipe.render(g2);            
        }
        logo.Paint(g2);       
    }

    @Override
    public void KEY_ACTION(KeyEvent e, int Event) {
        
        if(State == STATE.GAME){
            if(Event == KEY_PRESSED){
                if(CurrentScreen == BEGIN_SCREEN){
                    CurrentScreen = GAMEPLAY_SCREEN;
                }else if(CurrentScreen == GAMEPLAY_SCREEN){
                    if(bird.getLive()){
                        bird.setVt(kk);
                        bird.flap.play();
                    }
                }else if(CurrentScreen == GAMEOVER_SCREEN){
                    CurrentScreen = BEGIN_SCREEN;
                }
            }
        }
    }  
    
    private String getHightPoint(){
        // format: Name:point
        FileReader readFile = null;
        BufferedReader reader = null;
        try{
             readFile = new FileReader("hightpoint.txt");
             reader = new BufferedReader(readFile);
            return reader.readLine();
        }
        catch(Exception e){
            return "Nobody:0";
        }
        finally{
            try {
                if(reader != null)
                    reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void checkPoint() throws IOException{
        if(hightPoint.equals(""))
            return;
        
        if(Point > Integer.parseInt(hightPoint.split(":")[1])){
            String name = JOptionPane.showInputDialog("You set a new hight score. What is your name?");
            hightPoint = name + ":" + Point;
            
            File pointFile = new File("hightpoint.txt");
            if(!pointFile.exists()){
                try {
                    pointFile.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
            FileWriter  writeFile = null;
            BufferedWriter writer = null;
            try{
                writeFile = new FileWriter(pointFile);
                writer = new BufferedWriter(writeFile);
                writer.write(this.hightPoint);
            }
            catch(Exception e){}
            finally{
               try{
                    if(writer != null){
                        writer.close();
                    }
               }catch(Exception e){}
            }
        }
    }
}
