import java.sql.*;
import java.util.Observable;
import oracle.jdbc.pool.OracleDataSource;


public class SettingsList extends Observable {

    private static OracleDataSource ds = null;
    private String url = "jdbc:oracle:thin:@//10.50.205.21:1521/dbk.hwr-berlin.de";
    private String password = "neuesPw";
    private String user = "OOP2_SS23_G1_P1";

    public SettingsList() {
        try {
            ds = new OracleDataSource();

            ds.setDataSourceName("HWROracleDataSource");
            ds.setURL(url);

            ds.setUser(user);
            ds.setPassword(password);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getterMethode(String typ) {
        String pfad = null;
        System.out.println("awdawdawdawd");
        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM OOP2_SS23_G1_P1.SETTINGS")) {

            while (resultSet.next()) {
                pfad = resultSet.getString(typ);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pfad;
    }

    public String getSkin(String typ) {
        return getterMethode(typ);
    }

    public String getBackground(String typ) {
        return getterMethode(typ);
    }

    public void setterMethode(String typ, String pfad) {
        try (Connection connection = ds.getConnection()) {
            String deleteSql = "DELETE FROM Settings WHERE " + typ + " IS NOT NULL";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
            deleteStatement.executeUpdate();

            String sql = "INSERT INTO Settings (" + typ + ") VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pfad);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Erfolgreich aktualisiert");
            } else {
                System.out.println("Fehler beim aktualisieren");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setSkin(String typ, String pfad) {
        setterMethode(typ, pfad);

    }

    public void setBackground(String typ, String pfad) {
        setterMethode(typ, pfad);

    }
}
