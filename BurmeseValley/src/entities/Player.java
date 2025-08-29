package entities;


import java.awt.Graphics2D;
import java.io.IOException;


import javax.imageio.ImageIO;



import frame.Frame;
import input.KeyHandler;
import java.awt.image.BufferedImage;


public class Player extends Entity {

    Frame f1;
    KeyHandler H;


  public  Player(Frame f1,KeyHandler H){
                    //This mean this calss the other is input
        this.f1 = f1;
        this.H = H;
        setDefauleValue();
        getPlayerImage();

    }
    public void setDefauleValue(){
        positionX = 100;
      positionY= 100;
       speed = 4 ;
       direction = "Down"; //This is down is just for temporary


    };

    public void getPlayerImage(){

        

                                                                //This section take photo from res lib
            try{

                    //Right
                    rightwalk1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right1.png")); 
                    rightwalk2 = ImageIO.read(getClass().getResourceAsStream("/res/player/right2.png"));
                    rightwalk3 = ImageIO.read(getClass().getResourceAsStream("/res/player/right3.png"));
                    rightwalk4 = ImageIO.read(getClass().getResourceAsStream("/res/player/right4.png"));
                    rightwalk5 = ImageIO.read(getClass().getResourceAsStream("/res/player/right5.png"));
                    //Left 
                    leftwalk1 = ImageIO.read(getClass().getResourceAsStream("/res/player/left1.png")); 
                    leftwalk2 = ImageIO.read(getClass().getResourceAsStream("/res/player/left2.png"));
                    leftwalk3 = ImageIO.read(getClass().getResourceAsStream("/res/player/left3.png"));
                    leftwalk4 = ImageIO.read(getClass().getResourceAsStream("/res/player/left4.png"));
                    leftwalk5 = ImageIO.read(getClass().getResourceAsStream("/res/player/left5.png"));
                    //Top
                    top1 = ImageIO.read(getClass().getResourceAsStream("/res/player/top1.png"));
                    top2 = ImageIO.read(getClass().getResourceAsStream("/res/player/top2.png"));
                    top3 = ImageIO.read(getClass().getResourceAsStream("/res/player/top3.png"));
                    top4 = ImageIO.read(getClass().getResourceAsStream("/res/player/top4.png"));
                    top5 = ImageIO.read(getClass().getResourceAsStream("/res/player/top5.png"));
                    top6 = ImageIO.read(getClass().getResourceAsStream("/res/player/top6.png"));
                    //down
                     down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/down1.png"));
                     down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/down2.png"));
                     down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/down3.png"));
                     down4 = ImageIO.read(getClass().getResourceAsStream("/res/player/down4.png"));
                     down5 = ImageIO.read(getClass().getResourceAsStream("/res/player/down5.png"));
                     down6 = ImageIO.read(getClass().getResourceAsStream("/res/player/down6.png"));

                
            }catch(IOException e){
                   
                



                    e.printStackTrace();


            }

    }

    public void update(){

                       



                                    //This if(Or) Statement make chara will stand if not moving without this it wll move when u press or not
                    if(H.leftA == true || H.midS==true || H.rightD==true || H.upW == true){


                //This Calculation is player position releated to speed with key handler

                if(H.leftA == true){
                        direction = "Left";
                    
                        positionX -= speed; 
                        // if player pressed A it will move to left  we are in 100pixel X position so it will - and move to left        

                }else if
                (H.midS == true){
                        direction = "Down";
                  
                        
                        positionY += speed; 
                        // if player pressed S it will move to down  100 pixel move to Y position  + and move to down      

                }else if
                (H.rightD == true){
                     direction = "Right";
                  
                        positionX += speed; 
                        // if player pressed D it will move to right   100 pixle  move to X position + and move to right     

                }else if
                (H.upW == true){
                         direction = "Top";
                       
                        positionY -= speed; 
                        // if player pressed A it will move to top  100 pixel  move to Y position - and move to top     

                }











                                            //This one is a little confuse This one control movement animation
                 spritCounter++;

                if(spritCounter > 10 ){

                     spritNumber++;
                        if (spritNumber > 6) {  // loop back to frame 1 after 4
                    spritNumber = 1;
                     }
                    spritCounter = 0;

                }




            }else {
                                //This else will make standby position when unpress btn
                    spritNumber = 1;


            }




    }
    public void draw(Graphics2D g2D){


                    // g2D.setColor(Color.white);

                //we will fill reactangle to out frame x,y,w,h as testing
                //x is from frame top y is from frame size rectangle will exists
                //chaTileSize is charater size we alrady figure out


                                                                                //Remembet this we need to give chaTileSize as public
                // g2D.fillRect(positionX,positionY, f1.chaTileSize, f1.chaTileSize);

       //         --------------------------------------------------------------------------------------------
                //In this case we got userinput from direction then we will switch photo then it make walking animation

                  BufferedImage image = null;
                switch (direction) {


                  
                    case "Left":
                       if(spritNumber == 1 ){
                                  image = leftwalk1;
                        }
                        
                        if(spritNumber == 2 ){
                                  image = leftwalk2;
                        }
                        if (spritNumber == 3) {
                                image = leftwalk3;
                        }
                        if (spritNumber == 4) {
                            image = leftwalk4;
                        }
                        if(spritNumber == 5){
                            image = leftwalk5;
                        }
                        if(spritNumber == 6){
                            image = leftwalk4;
                        }
                         if(spritNumber == 7 ){
                                  image = leftwalk3;
                        }
                        
                        if(spritNumber == 8 ){
                                  image = leftwalk2;
                        }
                        if (spritNumber == 9) {
                                image = leftwalk1;
                        }

                        
                        
                        break;
                    
                    case "Right":
                        
                        if(spritNumber == 1 ){
                                  image = rightwalk1;
                        }
                        
                        if(spritNumber == 2 ){
                                  image = rightwalk2;
                        }
                        if (spritNumber == 3) {
                                image = rightwalk3;
                        }
                        if (spritNumber == 4) {
                            image = rightwalk4;
                        }
                        if(spritNumber == 5){
                            image = rightwalk5;
                        }
                        if(spritNumber == 6){
                            image = rightwalk4;
                        }
                         if(spritNumber == 7 ){
                                  image = rightwalk3;
                        }
                        
                        if(spritNumber == 8 ){
                                  image = rightwalk2;
                        }
                        if (spritNumber == 9) {
                                image = rightwalk1;
                        }
                        break;
                    case "Top":
                       if(spritNumber == 1 ){
                                  image = top1;
                        }
                        
                        if(spritNumber == 2 ){
                                  image = top2;
                        }
                        if (spritNumber == 3) {
                                image = top3;
                        }
                        if (spritNumber == 4) {
                            image = top4;
                        }
                        if(spritNumber == 5){
                            image = top5;
                        }
                        if(spritNumber == 6){
                            image = top6;
                        }
                         if(spritNumber == 7 ){
                                  image = top1;
                        }
                        
                       
                        
                        break;
                    case "Down":
                         if(spritNumber == 1 ){
                                  image = down1;
                        }
                        
                        if(spritNumber == 2 ){
                                  image = down2;
                        }
                        if (spritNumber == 3) {
                                image = down3;
                        }
                        if (spritNumber == 4) {
                            image = down4;
                        }
                        if(spritNumber == 5){
                            image = down5;
                        }
                        if(spritNumber == 6){
                            image = down6;
                        }
                         if(spritNumber == 7 ){
                                  image = down1;
                        }
                        
                        
                        break;
                
                    default:
                        break;
                }
               

                g2D.drawImage(image,positionX,positionY, character16x3W,character16x3H ,null);


    }


    
}
