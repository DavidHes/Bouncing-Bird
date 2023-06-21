import javax.swing.*;
import java.awt.event.*;

public class GameController implements ActionListener, MouseListener, KeyListener {

    MenuFundament menuFundament;
    RateGamePanel rgp;
    ScoreBoardPanel sbp;
    SettingsPanel settingspanel;
    GamePanel gamepanel;
    MenuPanel menuPanel;
    RateGameList rgList;
    ScoreboardList sbList;
    SettingsList settList;

    public GameController() {

        menuFundament = new MenuFundament();
        rgp = new RateGamePanel();
        sbp = new ScoreBoardPanel();
        settingspanel = new SettingsPanel();
        gamepanel = new GamePanel();
        rgList = new RateGameList();
        sbList = new ScoreboardList();
        settList = new SettingsList();
        menuPanel = new MenuPanel();

        new Timer(40, this::actionPerformed).start();

    }
    public void addModel (RateGameList rgL, ScoreboardList sbL,SettingsList settL ){
        this.rgList = rgL;
        this.sbList = sbL;
        this.settList = settL;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          gamepanel.dropbird();
          gamepanel.movetube();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        gamepanel.changebirdcord();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == e.VK_SPACE){
            gamepanel.changebirdcord();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

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

   /* public class MyMouseListener implements MouseListener {

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
    */

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
