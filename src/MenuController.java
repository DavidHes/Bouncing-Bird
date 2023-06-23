import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

    JFrame frame;
    MenuFundament menuFundament;
    RateGamePanel rateGamePanel;
    ScoreboardPanel scoreboardPanel;
    SettingsPanel settingsPanel;
    GamePanel gamePanel;
    MenuPanel menuPanel;
    RateGameList rgList;
    ScoreboardList sbList;
    SettingsList settList;
    GameController gameController;


    public MenuController() {

        frame = new JFrame();


        menuFundament = new MenuFundament();
        rateGamePanel = new RateGamePanel(this);
        scoreboardPanel = new ScoreboardPanel(this);
        settingsPanel = new SettingsPanel(this);
        gamePanel = new GamePanel(gameController);
        rgList = new RateGameList();
        sbList = new ScoreboardList();
        settList = new SettingsList();
        menuPanel = new MenuPanel();
        gameController = new GameController();

      /*  frame.add(rateGamePanel);
        frame.add(scoreboardPanel);
        frame.add(settingsPanel);
        frame.add(gamePanel);*/
//GEHT NICHT. MAN KANN NICHT ALLE AUFEINMAL HINZUFÜGEN
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
            showPanel(gamePanel, "Infos zu Start Game");
        } else if (buttonLabel.equals("Scoreboard")) {
            showPanel(scoreboardPanel, "Infos zu Scoreboard");
        } else if (buttonLabel.equals("Settings")) {
            showPanel(settingsPanel, "Infos zu Settings");
        } else if (buttonLabel.equals("Rate Game")) {
            showPanel(rateGamePanel, "Infos zu Rate Game");
        } else if (buttonLabel.equals("Back to Menu")) {
            showPanel(menuPanel, "Back to menu");
        }
    }
    private void showPanel(JPanel jPanel, String info) {
       /* menuPanel.setVisible(false);
        gamePanel.setVisible(false);
        settingsPanel.setVisible(false);
        rateGamePanel.setVisible(false);
        scoreboardPanel.setVisible(false);


        frame.add(jPanel);
        jPanel.setVisible(true);
        System.out.println(info);

        */

        frame.getContentPane().removeAll();
        frame.getContentPane().add(jPanel);
        jPanel.requestFocusInWindow();

        frame.revalidate();
        frame.repaint();
    }
}


