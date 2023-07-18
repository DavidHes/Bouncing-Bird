
import java.util.Observable;

public class SettingsList extends Observable {

    BouncingBirdDBDAO db = new BouncingBirdDBDAO();


    public void setSkin(String typ, String pfad) {
        db.setterMethode(typ, pfad);
    }

    public void setBackground(String typ, String pfad) {
        db.setterMethode(typ, pfad);
    }

    public String getSkin() {
        return db.getterMethode("VOGELSKIN");
    }

    public String getBackground() {
        return db.getterMethode("HINTERGRUND");
    }
}
