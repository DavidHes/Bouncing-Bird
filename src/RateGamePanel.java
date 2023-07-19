import java.awt.event.ActionListener;

public class RateGamePanel extends MenuBasis {

    public RateGamePanel(ActionListener actionListener) {
        add(backToMenuBut);

        backToMenuBut.addActionListener(actionListener);
    }
}
