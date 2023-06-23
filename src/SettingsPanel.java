import java.awt.event.ActionListener;

public class SettingsPanel extends MenuFundament {

    public SettingsPanel(ActionListener actionListener) {

        super();
        add(backToMenuBut);
        backToMenuBut.addActionListener(actionListener);

    }

}
