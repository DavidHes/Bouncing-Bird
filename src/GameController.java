import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameController implements ActionListener, MouseListener, KeyListener {
    private GamePanel gamePanel;
    private boolean gameStarted = false;

    MenuFundament menuFundament;

    //überföüssig
    RateGamePanel rgp;
    ScoreboardPanel sbp;
    SettingsPanel settingspanel;
    MenuPanel menuPanel;
    RateGameList rgList;
    ScoreboardList sbList;
    SettingsList settList;
    Timer time;

    public GameController(GamePanel gamePanel) {

        menuFundament = new MenuFundament();


      //  rgp = new RateGamePanel(this);
      //  sbp = new ScoreboardPanel(this);
        // settingspanel = new SettingsPanel(this);
        rgList = new RateGameList();
        sbList = new ScoreboardList();
        settList = new SettingsList();
     // überflüssig   menuPanel = new MenuPanel();
        this.gamePanel = gamePanel;
        gamePanel.addMouseListener(this);
        gamePanel.addKeyListener(this);


        gamePanel.backToMenuBut.addActionListener(this);
        gamePanel.restartBut.addActionListener(this);
        gamePanel.scorename.addActionListener(this);
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();

        time = new Timer(40, this::actionPerformed);
        time.start();

    }

    public void addModel(RateGameList rgL, ScoreboardList sbL, SettingsList settL) {
        this.rgList = rgL;
        this.sbList = sbL;
        this.settList = settL;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("gehts los?");
        if (gameStarted) {
           // System.out.println("los");
            gamePanel.checkTubeCollusion();
            gamePanel.checkBorderCollusion();

            gamePanel.updateScore();
            gamePanel.dropbird();
            gamePanel.movetube();

        }

        if (e.getSource() == gamePanel.restartBut) {
            System.out.println("hgä");
            gamePanel.restartTheGame();
            gameStarted = false;
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("maus klickt");

        //Startet das Spiel, sobald der Spieler auf den Bildschirm mit der Maus klickt bzw. auf die Entertaste drückt
        if (gameStarted == false) {
            gameStarted = true;
            System.out.println("JAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            gamePanel.startgame();
        }
        if(gameStarted== true){
            gamePanel.changebirdcord();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Maus wurde gedrückt");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Maus wurde released");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Maus wurde geenterd");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Maus wurde exit");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Tastur schreiben");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Tastendruck");
        if (e.getKeyCode() == KeyEvent.VK_ENTER && gameStarted == false) {
            System.out.println("Game startet");
            // Starte das Spiel, wenn der Benutzer die Eingabetaste drückt
            gameStarted = true;
            gamePanel.startgame();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE && gameStarted == true) {
            System.out.println("Game läuft");
            gamePanel.changebirdcord();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Tastendruck losgelassen");

    }

}
