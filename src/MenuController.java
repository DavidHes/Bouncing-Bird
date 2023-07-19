import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

    JFrame frame; //Damit man frame.add direkt hier ein panelwechsel machen kann
    MenuBasis menuBasis;
    RateGamePanel rateGamePanel;
    ScoreboardPanel scoreboardPanel;
    SettingsPanel settingsPanel;
    GamePanel gamePanel;
    MenuPanel menuPanel;
    RateGameList rgList;
    ScoreboardList sbList;
    SettingsList settList;
    GameController gameController;
    private JPanel currentPanel;


    public MenuController() {

        frame = new JFrame();

        menuBasis = new MenuBasis();
        rateGamePanel = new RateGamePanel(this);
        scoreboardPanel = new ScoreboardPanel(this);
        settingsPanel = new SettingsPanel(this);
        gamePanel = new GamePanel(gameController, this);
        rgList = new RateGameList();
        sbList = new ScoreboardList();
        settList = new SettingsList();
        menuPanel = new MenuPanel();
        gameController = new GameController(gamePanel);

        frame.add(menuPanel);
        menuPanel.addController(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonLabel = ((JButton) e.getSource()).getText();

        if (buttonLabel.equals("Start Game")) {
            showPanel(gamePanel);
        } else if (buttonLabel.equals("Scoreboard")) {
            showPanel(scoreboardPanel);
        } else if (buttonLabel.equals("Settings")) {
            showPanel(settingsPanel);
        } else if (buttonLabel.equals("Rate Game")) {
            showPanel(rateGamePanel);
        } else if (buttonLabel.equals("Back to Menu")) {
            if (currentPanel == gamePanel) {
                gamePanel.restartTheGame();
                GameController.gameStarted = false;
            }
            showPanel(menuPanel);
        }
    }

    private void showPanel(JPanel jPanel) {
        frame.getContentPane().removeAll();
        currentPanel = jPanel;
        frame.getContentPane().add(currentPanel);
        jPanel.requestFocusInWindow();
        frame.revalidate();
        frame.repaint();
    }
}





