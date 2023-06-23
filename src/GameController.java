import javax.swing.*;
import java.awt.event.*;

public class GameController implements ActionListener, MouseListener, KeyListener {

    MenuFundament menuFundament;
    RateGamePanel rgp;
    ScoreboardPanel sbp;
    SettingsPanel settingspanel;
    GamePanel gamepanel;
    MenuPanel menuPanel;
    RateGameList rgList;
    ScoreboardList sbList;
    SettingsList settList;
    Timer time;

    public GameController() {
        menuFundament = new MenuFundament();
        rgp = new RateGamePanel(this);
        sbp = new ScoreboardPanel(this);
        settingspanel = new SettingsPanel(this);
        rgList = new RateGameList();
        sbList = new ScoreboardList();
        settList = new SettingsList();
        menuPanel = new MenuPanel();

        gamepanel = new GamePanel(this);
        gamepanel.addMouseListener(this);
        gamepanel.addKeyListener(this);

        time = new Timer(40, this::actionPerformed);
    }

    public void addModel(RateGameList rgL, ScoreboardList sbL, SettingsList settL) {
        this.rgList = rgL;
        this.sbList = sbL;
        this.settList = settL;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("3");
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
        System.out.println("mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
        gamepanel.startgame();
        gamepanel.changebirdcord();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
    }
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");
    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_ENTER) {
            gamepanel.startgame();
        }

        if (code == KeyEvent.VK_SPACE) {
            gamepanel.changebirdcord();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased");
    }

    //public class startgameListener implements ActionListener {
    //   @Override
    //    public void actionPerformed(ActionEvent e) {
    //   }
    //  }

    public class MoveListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("2");
            //  birdyPOS = birdyPOS + drop;
        }
    }

    public class GameoverListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("1");


        }
    }
}