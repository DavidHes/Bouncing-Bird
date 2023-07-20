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
        ArrayList<String> list = new ArrayList<>();
        list = db.getScoreboard();
        for(int i = 0; i < list.size(); i++){
            String s = list.get(i);
            ScoreboardPanel.scorelist.add(s);
        }
        setChanged();
        notifyObservers(list);
        System.out.println("addScore Methode funktioniert");
    }
}
