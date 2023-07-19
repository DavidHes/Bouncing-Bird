import java.util.Observable;

public class RateGameList extends Observable {

 /*   private BouncingBirdDBDAO dbDAO;

    public RateGameList() {
        this.dbDAO = new BouncingBirdDBDAO();
    }

    public void writeReviewFile(String username, String comments, int rating) {
        dbDAO.addRating(username, comments, rating);
        setChanged();
        notifyObservers();
    }

    public List<Rating> renderReview() {
        return dbDAO.getRatings();
    }

    public DefaultTableModel getRatingsTableModel() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Username", "Comment", "Rating"}, 0);
        List<Rating> ratings = renderReview();

        for (Rating rating : ratings) {
            model.addRow(new Object[]{rating.getUsername(), rating.getComment(), rating.getRating()});
        }

        return model;
    }*/
}
