
import java.util.Observable;

public class RateGameList extends Observable {

    BouncingBirdDBDAO db = new BouncingBirdDBDAO();

    public void addRating(String username, String comments, int rating) {
        db.addRating(username, comments, rating);
    }

    public void getRating() {
        String rating = db.getRatings();
        RateGamePanel.reviewLabel.setText(db.getRatings());
        setChanged();
        notifyObservers(rating);
    }
}
