import java.sql.*;
import java.util.ArrayList;

public class BouncingBirdDBDAO implements BouncingBirdDAO {

    OracleDsSingleton ora = OracleDsSingleton.getInstance();

    /**
     * @param typ
     * @return
     */
    @Override
    public String getterMethode(String typ) {

        Statement statement = null;
        ResultSet resultSet = null;

        String name = null;
        try {
            Connection connection = ora.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM OOP2_SS23_G1_P1.SETTINGS ORDER BY TIMESTAMP DESC");

            while (resultSet.next()) {
                String string = resultSet.getString("COLLECTION");
                if (string.charAt(0) == typ.charAt(0)) {
                    name = resultSet.getString("COLLECTION");

                    resultSet.close();
                    statement.close();
                    connection.close();
                    break; // Abbrechen, wenn der gewünschte Eintrag gefunden wurde
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;

    }


    @Override
    public void setterMethode(String typ, String pfad) {

        PreparedStatement statement = null;

        try (Connection connection = ora.getConnection()) {
            String sql = "INSERT INTO SETTINGS (COLLECTION, TIMESTAMP) VALUES (?, CURRENT_TIMESTAMP)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, pfad);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<String> getScoreboard() {

        Statement statement = null;
        ResultSet resultSet = null;

        String username = null;
        String userscore = null;

        ArrayList<String> scoreList = new ArrayList<>();

        try {
            Connection connection = ora.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM OOP2_SS23_G1_P1.SCOREBOARD ORDER BY TIMESTAMP DESC");

            while (resultSet.next()) {
                username = resultSet.getString("NAME");
                userscore = resultSet.getString("HIGHSCORE");
                scoreList.add(username);
                scoreList.add(userscore);

                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scoreList;

    }

    @Override
    public void setScore(String name, int score) {

        PreparedStatement statement = null;

        try (Connection connection = ora.getConnection()) {
            String sql = "INSERT INTO HIGHSCORE (HIGHSCORE, NAME, TIMESTAMP) VALUES (?, ?, CURRENT_TIMESTAMP)";
            statement = connection.prepareStatement(sql);
            statement.setString(2, name);
            statement.setInt(1, score);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addRating(String username, String comments, int rating) {
        try (Connection connection = ora.getConnection()) {
            String sql = "INSERT INTO RATINGS (USERNAME, COMMENTS, RATING, TIMESTAMP) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, comments);
            statement.setInt(3, rating);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Erfolgreich aktualisiert");
            } else {
                System.out.println("Fehler beim Aktualisieren");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getRatings() {
        StringBuilder ratingsStringBuilder = new StringBuilder();
        try (Connection connection = ora.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM RATINGS ORDER BY TIMESTAMP DESC")) {

            while (resultSet.next()) {
                String username = resultSet.getString("USERNAME");
                String comment = resultSet.getString("COMMENTS");
                int rating = resultSet.getInt("RATING");
                ratingsStringBuilder.append("Username: ").append(username)
                        .append(", Comment: ").append(comment)
                        .append(", Rating: ").append(rating)
                        .append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratingsStringBuilder.toString();
    }
}