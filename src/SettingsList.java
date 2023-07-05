
import java.util.Observable;

public class SettingsList extends Observable {

    BouncingBirdDBDAO db = new BouncingBirdDBDAO();
    public SettingsList(){

    }

    public void setSkin(String typ, String pfad) {
        db.setterMethode(typ, pfad);
    }

    public void setBackground(String typ, String pfad) {
        db.setterMethode(typ, pfad);
    }

    public String getSkin(String typ) {
        return db.getterMethode(typ);
    }

    public String getBackground(String typ) {
        return db.getterMethode(typ);
    }
}
