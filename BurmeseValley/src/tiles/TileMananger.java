package tiles;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


import frame.Frame;

public class TileMananger {
    
        Frame f2;       //This is our frame class
        Tiles [] tile;  //This Tile is Tile class we create and take as Object array it might exisit depend on what u fill as
                        //Tips:  Class can make array of object 







        public TileMananger(Frame f1){

                   f2 = f1;

                    //Size of tiles

                    tile = new Tiles[10];  // This mean we going to create 10 kind of tiles for now if i have much more tile
                                            //We gonna change this later

                   getTileImages();
                   



        }
                                //Rescourse input
        public void getTileImages(){


                try {
                    tile[0] = new Tiles();
                    
                    //This is calling image variable inside Tileclass as .image then we took the photo as buffered image
                    tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles_res/OakFloor1.png"));



                } catch (IOException e) {
                   e.printStackTrace();
                }


        }
                            //Draw Graphic

        public void drawGraphic(Graphics2D g){

                        //Draw image method is build in methode in graphic2d lib 
      //  g.drawImage(tile[0].image,0,0,96,96,null);  // this methode is work but not effient so we need to use loop and text file reader

         



                int row = 0;            //position and column
                int col = 0;
                int xposi =  0;
                int yposi = 0;


                //if both condition true it will loop 
                //we have 16 col and 12 role for block each blocks have 48pixel width and 48 pixel height
          while (col < f2.screenCol && row < f2.screenRow) {

                        g.drawImage(tile[0].image, xposi,yposi, f2.chaTileSize, f2.chaTileSize, null);
                        col++;
                        xposi += tile[0].tilePixel48; // So this line is like i need 48 pixle for a row that why i place tile48 in Tileclas

                       
                        if(col == f2.screenCol){

                            col = 0;
                            xposi = 0;
                            row++;
                            yposi += tile[0].tilePixel48;
                          
                        }

              
                
            }

//        g.setColor(Color.RED);
// g.fillRect(0, 0, 48, 48);

// g.setColor(Color.BLUE);
// g.fillRect(48, 0, 48, 48);

// g.setColor(Color.GREEN);
// g.fillRect(96, 0, 48, 48);
 
           




           

        }


}
