import java.util.ArrayList;
import java.util.Observable;

public class ScoreboardList extends Observable {

   private int score;
    BouncingBirdDBDAO db = new BouncingBirdDBDAO();

    public ScoreboardList() {
    }

   public void addScore(String name, int score){
   }
    public void renderScoreboard(){
        ArrayList<String> list = db.getScoreboard();
        setChanged();
        notifyObservers(list);
        System.out.println("addScore Methode funktioniert");
    }
}
