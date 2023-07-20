import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScoreboardPanel extends MenuBasis {

    static JLabel scoreLabel;

    ScoreboardList scoreboardList = new ScoreboardList();

    static ArrayList<String> scorelist = new ArrayList<>();

    public ScoreboardPanel(ActionListener actionListener) {

        setLayout(null);
        scoreLabel = new JLabel();
        scoreLabel.setBounds(10, 250, 2000, 50);
        add(scoreLabel);

        for(int i = 0; i < scorelist.size(); i++) {
            System.out.println(scorelist.get(i));
        }

        backToMenuBut.setBounds(144, 650, 150, 50);
        add(backToMenuBut);
        backToMenuBut.addActionListener(actionListener);

        scoreboardList.addObserver(this);
        scoreboardList.renderScoreboard();

        repaint();
    }
}

