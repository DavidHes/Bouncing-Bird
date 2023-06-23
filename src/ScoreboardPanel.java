import java.awt.event.ActionListener;

public class ScoreboardPanel extends MenuFundament {

    public ScoreboardPanel(ActionListener actionListener) {

        add(backToMenuBut);

        backToMenuBut.addActionListener(actionListener);
    }
}
