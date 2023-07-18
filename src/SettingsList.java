
import java.util.Observable;

public class SettingsList extends Observable {

    BouncingBirdDBDAO db = new BouncingBirdDBDAO();


    public void setSkin(String typ, String pfad) {
        db.setterMethode(typ, pfad);
    }

    public void setBackground(String typ, String pfad) {
        db.setterMethode(typ, pfad);
    }

    public void getSkin() {
        String skin = db.getterMethode("VOGELSKIN");
        setChanged();
        notifyObservers(skin); // Übergebe den aktuellen Pfad als Argument
        System.out.println("getskin Methode funktioniert");
       // return db.getterMethode("VOGELSKIN");
    }

    public void getBackground() {
        String background = db.getterMethode("HINTERGRUND");
        setChanged();
        notifyObservers(background); // Übergebe den aktuellen Pfad als Argument
        System.out.println("getbackground Methode funktioniert");
    }
}
