import java.io.InputStream;

import javax.swing.JFrame;

import entities.Player;

import  java.lang.Object;



//package import
import frame.Frame;

public class App {




    public static void main(String[] args) throws Exception {
        
            JFrame window = new JFrame();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);
            window.setTitle("BurmeseValley");


            //Calling packaage

             Frame GamePanel = new Frame();


            //Add to window
            window.add(GamePanel);

            //Pack make  Reponsive with Dimension 
            window.pack();

             GamePanel.startTheGame();











                                        //Remeber This this setVisibleline is a ashit even you right it make bad your dayyyyyyyy shhhhtiittt
                                        //I stuck in choossing path because of this
            window.setVisible(true);
            window.setLocationRelativeTo(null); // The window will pop in the middele of the screen

            



    }




}
