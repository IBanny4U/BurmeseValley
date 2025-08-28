import javax.swing.JFrame;



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



            window.setVisible(true);
            window.setLocationRelativeTo(null); // The window will pop in the middele of the screen

            
            GamePanel.startTheGame();



    }




}
