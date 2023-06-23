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
    Timer time = new Timer (40, this::actionPerformed);

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

    }
    public void addModel (RateGameList rgL, ScoreboardList sbL,SettingsList settL ){
        this.rgList = rgL;
        this.sbList = sbL;
        this.settList = settL;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

          gamepanel.checkTubeCollusion();
          gamepanel.checkBorderCollusion();

          gamepanel.dropbird();
          gamepanel.movetube();

          if(e.getSource()== gamepanel.restartBut){
              gamepanel.restartTheGame();
          }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        gamepanel.startgame();
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

        if(code == e.VK_ENTER) {
            gamepanel.startgame();
        }

        if(code == e.VK_SPACE){
            gamepanel.changebirdcord();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

    //public class startgameListener implements ActionListener {
     //   @Override
    //    public void actionPerformed(ActionEvent e) {
     //   }
  //  }

    public class MoveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

          //  birdyPOS = birdyPOS + drop;
        }
    }

    public class GameoverListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }
}
