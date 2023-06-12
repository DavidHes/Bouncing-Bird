import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameController {

    RateGameList rgList;
    ScoreboardList sbList;
    SettingsList settList;

    public GameController() {

        rgList = new RateGameList();
        sbList = new ScoreboardList();
        settList = new SettingsList();
    }
    public void addModel (RateGameList rgL, ScoreboardList sbL,SettingsList settL ){
        this.rgList = rgL;
        this.sbList = sbL;
        this.settList = settL;
    }

    public class startgameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
         //   if(e.getSource() == startBut) {
            //    gameover = false;
            //    visible = false;
          //  }

        //    if(e.getSource() == but5) {

         //   }
        }
    }

    public class MyMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
       }
      @Override
       public void mousePressed(MouseEvent e) {
        //    if(gameover == false) {
          //      start = St;
         //       birdyPOS = birdyPOS - inc;
           //     time.stop();
         //  }
        }
        @Override
        public void mouseReleased(MouseEvent e) {
          //  if(gameover == false) {
              //  time.start();
           // }
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public class MoveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

          //  birdyPOS = birdyPOS + drop;
        }
    }

    public class GameoverListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //birdyPOS = birdyPOS + gameoverdrop;
        }
    }
}
