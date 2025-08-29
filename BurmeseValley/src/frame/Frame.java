package frame;

import javax.swing.JPanel;

import entities.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;



//Other Package
import input.KeyHandler;

public class Frame extends JPanel implements Runnable{

        //Fps
        int Fps = 60;




     final int originalTileSize = 16;   //W x H = 16:16
     final int scale = 4;           // When The Screen become large it will become 48x48

    public final int chaTileSize =  originalTileSize * scale ; //48

    //This one is How many tile i want to show in screen let's try 16x12 4:3
    // but i have to multiply with cha size like 48x16 

    final int screenCol = 16;
    final int screenRow = 12; //4:3


    final int maxScreenWidth = screenCol * chaTileSize; //So We got 768 Pixel
    final int maxScreenHight = screenRow * chaTileSize ; //So We got 576 Pixel  
    //This is Totla frame character will  be 48x48 Pixel in Frame width 768 Pixel and Height 576 Pixel

        //As I know gameThread is used to loop our game again and again 
        //IDk much but Just Trying for the first time 
        //We need Run() methode for implenting runnable it is make by Runnable class not me
        Thread gameThread;




       
        
        


        //This is Keyhandler
        KeyHandler keyH = new KeyHandler();


        


         //This is Player Class Declearation



                                               //This mean this class Frame 
        Player player = new Player(this,keyH);

    //Constructor
    public Frame (){

            this.setPreferredSize(new Dimension(maxScreenWidth,maxScreenHight));
            this.setBackground(Color.WHITE); // Because I hate to write with seeing nothing lmao
            
            //I don't know much about this but long story short it is improve game
            //rendering Perfomance 
            this.setDoubleBuffered(true); 


            // add keylistener to the frame
            this.addKeyListener(keyH);
            this.setFocusable(true); // as i know this line will make frame Focus on keylistener











    }




       
    public void startTheGame(){

                                //this mean this class
                gameThread = new Thread(this);


                                //Basically When we start Threat.start()  it's automatically call run() methode
                gameThread.start();





    }



                                //This will be the core code. Run()Methode is need to write when implenting runnable class
    @Override
    public void run(){


                // in this section we need to know 1,000,000,000 nanoSecond is 1second
                //We need to limit looping time as 60Fps without this computer work 1 million loop in 1 sec idk exactly
                //So we need to limit frame within 60 FPS and keep in the our frame 
                //Without this section out character will disspear because of moving too fast and reach out of our frame
                //There is 2 methode 1 is sleepmethode and the other is Delta we will use delta methode


                double drawInterval = 1000000000/Fps; //This line will take 16666666.66 as  drawInterval
                double delta = 0;
                long lastTime = System.nanoTime();
                long  currentTime;
                long timer = 0;
                int drawCount = 0;




        //As long as the game open it will be exists so i will use while loop
        while (gameThread != null ) {
                
                currentTime = System.nanoTime();
                delta += (currentTime - lastTime ) / drawInterval ;

                timer  += (currentTime - lastTime );
                //After changing delta value set current time as last time
                lastTime = currentTime;

                if(delta >= 1 ){

                                 Update();                      //UPDATE N REPAINT HERE
                                 repaint();
                                 delta --;  
                                 drawCount ++;



                }
                if(timer >= 1000000000 ){

                                System.out.println("FPS : " + drawCount );
                                
                                //Reset
                                drawCount = 0;
                                timer = 0;

                }



        //We need two methode for this loop it's updating and Reapainting
        //As long as the loop existis it will update and repaaint again and again




                     //  Update();

                        //repaint is build in methode when we use paintComponent not by me
                     //  repaint();





        }


    }
                                //This is for userUpdate when user move it will update
      public void Update(){
                                //player methode is in entities package
                player.update();


         };
                                //This is build-in methode not by me it will rewrite after update
        public void paintComponent(Graphics g){


                //super mean JPanel 
                super.paintComponent(g);

                //This is like we are overwrting Graphic to Graphics2D 
                //Graphic2d have more function so that why we change
                Graphics2D g2D =  (Graphics2D)g;
    

                        player.draw(g2D);

                //IDk much about dispose but it said like to save memory 
                g2D.dispose();

        }

};