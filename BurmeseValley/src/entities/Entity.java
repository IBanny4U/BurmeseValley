package entities;
import java.awt.image.BufferedImage;



public class Entity {
    
    //This is the superClass of all Character Player,NPC,Monster

    public int positionX,positionY;
    public int speed;

        //This variable will hold all the photo of npc
        //Type is Bufferimage
        //Buffer image is under awt.image
        public BufferedImage rightwalk1,rightwalk2,rightwalk3,rightwalk4,rightwalk5;
         public BufferedImage leftwalk1,leftwalk2,leftwalk3,leftwalk4,leftwalk5;
         public BufferedImage top1,top2,top3,top4,top5,top6;
         public BufferedImage down1,down2,down3,down4,down5,down6;
        public String direction;



        //Walk animaion with this variable
        public int spritCounter = 0;
        public int spritNumber = 1;


        //I want character like 2block height and 1 block width 
        //Depend on charScale i choose 48x96  scale is 16x3 name like chartile in frame.java
        public int character16x3W = 48 ;
        public int character16x3H = 96 ;  



    
}
