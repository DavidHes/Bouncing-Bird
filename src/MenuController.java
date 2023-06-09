import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener{

    RateGameList rgList;
    ScoreboardList sbList;
    SettingsList settList;

    public MenuController() {

        rgList = new RateGameList();
        sbList = new ScoreboardList();
        settList = new SettingsList();
}
    public void addModel (RateGameList rgL, ScoreboardList sbL,SettingsList settL ){
        this.rgList = rgL;
        this.sbList = sbL;
        this.settList = settL;
    }

    @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == ) {
            }

            if (e.getSource() == settingsBut) {
            }

            if (e.getSource() == rateGameBut) {
            }
            if (e.getSource() == backToMenuBut) {
            }
        }
}
