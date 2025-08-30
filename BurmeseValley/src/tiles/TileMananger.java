package tiles;

import java.awt.Graphics2D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;


import frame.Frame;

public class TileMananger {
    
        Frame f2;       //This is our frame class
        Tiles [] tileInv;  //This Tile is Tile class we create and take as Object array it might exisit depend on what u fill as
                        //Tips:  Class can make array of object 


        int mapData [][];




        public TileMananger(Frame f1){
                       
                   f2 = f1;

                    //Size of tiles

                    tileInv = new Tiles[10];  // This mean we going to create 10 kind of tiles for now if i have much more tile
                                              //We gonna change this later



                        mapData = new int[f2.screenCol][f2.screenRow]; //This will fill txt data 






                 getTileImages();
                 mapLoader("../res/mapData/house.txt");
                   



        }
                                //Rescourse input
        public void getTileImages(){


                try {
                    tileInv[0] = new Tiles();  
                    //This is calling image variable inside Tileclass as .image then we took the photo as buffered image
                    tileInv[0].image = ImageIO.read(getClass().getResourceAsStream("../res/resTiles/OakFloor1.png"));

                    tileInv[1] = new Tiles();
                    tileInv[1].image = ImageIO.read(getClass().getResourceAsStream("../res/resTiles/leftwallOakfillblack.png"));

                    tileInv[2] = new Tiles();
                    tileInv[2].image = ImageIO.read(getClass().getResourceAsStream("../res/resTiles/rightwallOakfillblack.png"));


                    tileInv[3] = new Tiles();
                    tileInv[3].image = ImageIO.read(getClass().getResourceAsStream("../res/resTiles/topwallOakfillblack.png"));

                    tileInv[4] = new Tiles();
                    tileInv[4].image = ImageIO.read(getClass().getResourceAsStream("../res/resTiles/downwallOakfillblack.png"));

                    tileInv[5] = new Tiles();
                    tileInv[5].image = ImageIO.read(getClass().getResourceAsStream("../res/resTiles/leftConer.png"));

                    tileInv[6] = new Tiles();
                    tileInv[6].image = ImageIO.read(getClass().getResourceAsStream("../res/resTiles/rightconerup.png"));

                    tileInv[7] = new Tiles();
                    tileInv[7].image = ImageIO.read(getClass().getResourceAsStream("../res/resTiles/rightconerdown.png"));

                    tileInv[8] = new Tiles();
                    tileInv[8].image = ImageIO.read(getClass().getResourceAsStream("../res/resTiles/lefttconerdown.png"));

                    




                } catch (IOException e) {
                   e.printStackTrace();
                }


        }
                                //This Methode will read the data in the txt file

        public void mapLoader(String map){

                try {
                                                                                        //inputStram is to input tx file
                                                                                        //BufferedReader is to read the file
                                                                                        //This is format for reading txt file
                                                                                //This parameter is String type
                                InputStream iS = getClass().getResourceAsStream(map);

                                BufferedReader bR = new BufferedReader(new InputStreamReader(iS));



                                //Then we will loop to read and fill data 

                                int row =0;
                                int col = 0;


                                while (col <f2.screenCol && row <f2.screenRow) {
                                        // first we will read txt and fill in colLine 
                                
                                        String colLine = bR.readLine(); 

                                       while (col< f2.screenCol) {
                                                                                //in the sectiom read line skip space that is why 
                                                                                   //we need to split coline to get single number
                                                   String mapIndex[] = colLine.split(" ");     
                                                      
                                                                                //then we type cast String as intenger
                                                                                //it will get String but now we got int number in indexNum
                                                int indexNum = Integer.parseInt(mapIndex[col]);
                                                mapData[col][row] = indexNum;
                                              
                                               
                                                col++;

                                                }
                                                if (col== f2.screenCol) {
                                                        col = 0;
                                                        row++;
                                                        
                                                }
                                                 System.out.print(mapData[row][col]+ " ");


                                        
                                }
                                          bR.close();





                        
                } catch (Exception e) {
                       
                }



        };


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

                int tileIndex = mapData [col][row];

                       g.drawImage( tileInv[tileIndex].image , xposi,yposi, f2.chaTileSize, f2.chaTileSize, null);
                        
                        col++;
                        xposi += tileInv[tileIndex].tilePixel48; // So this line is like i need 48 pixle for a row that why i place tile48 in Tileclas

                       
                        if(col == f2.screenCol){

                            col = 0;
                            xposi = 0;
                            row++;
                            yposi += tileInv[tileIndex].tilePixel48;
                          
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
