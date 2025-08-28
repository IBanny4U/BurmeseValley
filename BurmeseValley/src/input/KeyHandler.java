package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

        //This is new for me we need userinput keylistener aswd as boolean
        //In keylistener there is 3 methode but we will use 2 of them
        //If there is no 3 methode the error will be occur
        //but in this pj i will use kust two of them keyPressed and keyReleased
public class KeyHandler implements KeyListener {
    
        //This Boolean is catch user pressed or do not pressed
        public boolean leftA,midS,rightD,upW;


        //first methode is keytyped (I don't use now)
        @Override
        public void keyTyped(KeyEvent e){

        }



        //The Second one is keypressed it work when user pressed
        @Override
        public void keyPressed(KeyEvent e){

            int userKey = e.getKeyCode(); //getkeyCode return what user pressed

                                            //This mean if user press A
            if(userKey == KeyEvent.VK_A){
                        leftA = true;

            }
                                            //This mean if user press S
            if(userKey == KeyEvent.VK_S){

                        midS = true;
            }
                                            //This mean if user press D
            if(userKey == KeyEvent.VK_D){

                        rightD = true;
            }
                                            //This mean if user press W
            if(userKey == KeyEvent.VK_W){

                        upW = true;
            }


        }



        //The third one is keyreleased it work when user released
        @Override
        public void keyReleased(KeyEvent e){


            
            int userKey = e.getKeyCode(); //getkeyCode return what user pressed

                                            //This mean if user press A
            if(userKey == KeyEvent.VK_A){
                        leftA = false;

            }
                                            //This mean if user press S
            if(userKey == KeyEvent.VK_S){

                        midS = false;
            }
                                            //This mean if user press D
            if(userKey == KeyEvent.VK_D){

                        rightD = false;
            }
                                            //This mean if user press W
            if(userKey == KeyEvent.VK_W){

                        upW = false;
            }

        }






}
