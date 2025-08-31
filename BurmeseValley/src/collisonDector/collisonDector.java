package collisonDector;
import entities.Entity;
import entities.Player;
import frame.Frame;



public class collisonDector {
    
        Frame frameCollison;



    public collisonDector(Frame f){

        frameCollison = f ;



    }

                            //This section is a little bit confuse but we got this
                            //We will take every entites like monster,npc,other stuff as parameter to check where they are
                            //Entity is Super class of every  chara so we can put its sub class as parameter
                            //we can instantiate in frame now
    public void checkTile(Entity s){

                    //In this section  we need to know where player exisit as pixel then we will + - to get solid area

                    //first we will calculate left side top buttom of solid Area
                    //we take x y position and + collisonArea 
                    //x , y calculating logic is from map x to reach chara x then calculate

                    int leftSolidArea = s.positionX + s.collisionArea.x;
                    int rightSolidArea = s.positionX + s.collisionArea.x + s.collisionArea.width;
                    int topSolidArea = s.positionY +  s.collisionArea.y;
                    int downSolidArea = s.positionY +  s.collisionArea.y + s.collisionArea.height;


                    //Now we got All Solid Area as pixel 
                    //Then we will calculate which tile we reach now we need to divide with our tiles to know colum
                    //example we reach pixel like 450 then we divided with tilesize 48 now we got 9.375 
                    //This mean we reach 9 column now we know where our solidArea exisits

                    int leftSolidAreaCol = leftSolidArea / frameCollison.chaTileSize;  // we got left Solid col position
                    int rightSolidAreaCol = rightSolidArea / frameCollison.chaTileSize;  // we got right Solid col position
                    int downSolidAreaRow = downSolidArea / frameCollison.chaTileSize;  // we down left Solid col position
                    int topSolidAreaRow = topSolidArea / frameCollison.chaTileSize;  // we top left Solid col position


                    //After that we need two more intenger to detecd position to know Collison ture or false
                    //This process calculate according to solidArea that we figure out
                    
                    int tilenum1,tilenum2;
 
                                //This direction get from player update 
                                //it change everytime when player move
                    switch (s.direction) {
                                //Accordig to the player movement this section will give player SolidArea
                        case "Left":

                            leftSolidAreaCol = (leftSolidArea - s.speed)/frameCollison.chaTileSize;

                            tilenum1 = frameCollison.Invtiles.mapData[leftSolidAreaCol][topSolidAreaRow];
                            tilenum2 = frameCollison.Invtiles.mapData[leftSolidAreaCol][downSolidAreaRow]; 

                                    if(frameCollison.Invtiles.tileInv[tilenum1].collision == true || frameCollison.Invtiles.tileInv[tilenum2].collision == true){

                                            s.collisionOn = true ; 


                                    }

                            break;
                        case "Down":
                                                                                //If you don't plus or minus speed collison is fone but it will stop moving
                                                                                //when you close to the wall
                             downSolidAreaRow = (downSolidArea + s.speed)/frameCollison.chaTileSize;

                            tilenum1 = frameCollison.Invtiles.mapData[leftSolidAreaCol][downSolidAreaRow];
                            tilenum2 = frameCollison.Invtiles.mapData[rightSolidAreaCol][downSolidAreaRow]; 

                                    if(frameCollison.Invtiles.tileInv[tilenum1].collision == true || frameCollison.Invtiles.tileInv[tilenum2].collision == true){

                                            s.collisionOn = true ; 


                                    }

                            break;
                        case "Right":
                            rightSolidAreaCol = (rightSolidArea + s.speed)/frameCollison.chaTileSize;

                            tilenum1 = frameCollison.Invtiles.mapData[rightSolidAreaCol][topSolidAreaRow];
                            tilenum2 = frameCollison.Invtiles.mapData[rightSolidAreaCol][downSolidAreaRow]; 

                                    if(frameCollison.Invtiles.tileInv[tilenum1].collision == true || frameCollison.Invtiles.tileInv[tilenum2].collision == true){

                                            s.collisionOn = true ; 


                                    }

                            break;
                        case "Top":

                                                    //in this section we - speed to calculate the next position of character
                                                   
                            topSolidAreaRow = (topSolidArea - s.speed)/frameCollison.chaTileSize;

                            tilenum1 = frameCollison.Invtiles.mapData[leftSolidAreaCol][topSolidAreaRow];//left top coner ,make sure we have to take column not pixel
                            tilenum2 = frameCollison.Invtiles.mapData[rightSolidAreaCol][topSolidAreaRow]; //right top coner

                                    if(frameCollison.Invtiles.tileInv[tilenum1].collision == true || frameCollison.Invtiles.tileInv[tilenum2].collision == true){

                                            s.collisionOn = true ; //if one of the coner hit when moving it will change to true and will not pass collision true block


                                    }

                            break;
                        
                        default:
                            break;
                    }









    }





}
