import javax.swing.*;
import java.awt.event.*;

public class GameController implements ActionListener, MouseListener, KeyListener {
    private GamePanel gamePanel;

    public static boolean gameStarted = false;

    MenuBasis menuBasis;

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

        menuBasis = new MenuBasis();
        rgList = new RateGameList();
        sbList = new ScoreboardList();
        settList = new SettingsList();
        this.gamePanel = gamePanel;
        gamePanel.addMouseListener(this);
        gamePanel.addKeyListener(this);

        gamePanel.backToMenuBut.addActionListener(this);
        gamePanel.restartBut.addActionListener(this);

        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();

        time = new Timer(40, this::actionPerformed);
        time.start();

    }

    //Überflüssig
    public void addModel(RateGameList rgL, ScoreboardList sbL, SettingsList settL) {
        this.rgList = rgL;
        this.sbList = sbL;
        this.settList = settL;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameStarted) {
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

        if (e.getSource() == gamePanel.addscore) {
            System.out.println("haaaaaaä");
            gamePanel.addTheScore();
            gameStarted = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("maus klickt");

        //Startet das Spiel, sobald der Spieler auf den Bildschirm mit der Maus klickt bzw. auf die Entertaste drückt
        if (gameStarted == false) {
            gameStarted = true;
            gamePanel.startgame();
        }
       if (gameStarted == true) {
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
    }

    @Override
    public void mouseExited(MouseEvent e) {

        System.out.println("Maus wurde exit");
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * In dieser
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Tastendruck");
        if (e.getKeyCode() == KeyEvent.VK_ENTER && gameStarted == false) {
            System.out.println("Game startet");
            // Starte das Spiel, wenn der Benutzer die Eingabetaste drückt
            gameStarted = true;
          //  gamePanel.gameOver = false;
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
