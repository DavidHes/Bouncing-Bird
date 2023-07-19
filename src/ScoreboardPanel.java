import javax.swing.*;
import java.awt.event.ActionListener;

public class ScoreboardPanel extends MenuBasis {

    static JLabel scoreLabel = new JLabel("testttt");

    ScoreboardList scoreboardList = new ScoreboardList();

    public ScoreboardPanel(ActionListener actionListener) {

        add(backToMenuBut);

        scoreboardList.addObserver(this);

        add(scoreLabel);

        scoreboardList.renderScoreboard();

        backToMenuBut.addActionListener(actionListener);
        repaint();
    }
}
