import java.sql.*;
import java.util.ArrayList;

public class BouncingBirdDBDAO implements BouncingBirdDAO{

    OracleDsSingleton ora = OracleDsSingleton.getInstance();
  /*  private static OracleDataSource ds = null;
    private String url = "jdbc:oracle:thin:@//10.50.205.21:1521/dbk.hwr-berlin.de";
    private String password = "neuesPw";
    private String user = "OOP2_SS23_G1_P1";
*/

    public BouncingBirdDBDAO() {
     /*   try {
            ds = new OracleDataSource();

            ds.setDataSourceName("HWROracleDataSource");
            ds.setURL(url);

            ds.setUser(user);
            ds.setPassword(password);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }

    ///////////////////CLOSE FEHLT NOCH!!!!!!!!!!!!!!!

    /**
     *
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
                   // System.out.println("Folgender Hintergrund ist der aktuellste: " + name);
                    break; // Abbrechen, wenn der gewünschte Eintrag gefunden wurde
                } else {
                  //  System.out.println("Fehler");
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
            String sql = "INSERT INTO SETTINGS (HIGHSCORE, NAME, TIMESTAMP) VALUES (?, ?, CURRENT_TIMESTAMP)";
            statement = connection.prepareStatement(sql);
            statement.setString(2, name);
            statement.setInt(1, score);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
