import java.awt.event.ActionListener;

public class RateGamePanel extends MenuFundament {

    public RateGamePanel(ActionListener actionListener) {
        add(backToMenuBut);

        backToMenuBut.addActionListener(actionListener);
    }
}
