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

    ///////////////////CLOSE FEHLT NOCH!!!!!!!!!!!!!!!

    public String getterMethode(String typ) {
        String pfad = null;
        System.out.println("awdawdawdawd");
        try (Connection connection = ds.getConnection();

             //Ist der Treiber geladen und die Verbindung hergestellt,
              //  benötigen Sie ein Objekt der Klasse Statement zum Absetzen von SQL-Kommandos

             Statement statement = connection.createStatement();

           //  Mit der Methode execute() des Statement-Objekts wird eine SQL-Anweisung ausgeführt
           //  execute() erzeugt eine Ergebnismenge, die mit Hilfe eines Objekts der Klasse ResultSet ausgelesen werden kann
      //  ResultSet rs = stm.getResultSet();  Mit Methoden des ResultSet-Objekts können Daten gelesen und Java-
            //    Variablen zugewiesen werden.

             ResultSet resultSet = statement.executeQuery("SELECT * FROM OOP2_SS23_G1_P1.SETTINGS")) {
            //Tabelle in resultset gespeichert.

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

           // Müssen Host-Variablen in ein SQL-Statement eingefügt werden, empfiehlt sich die Verwendung eines PreparedStatement.
               //     Dabei steht jedes ? für eine Variable, die mit setter- Methoden gesetzt werden.

            statement.setString(1, pfad);

           // Sie schreiben Änderungen direkt in die Datenbank mit der Methode executeUpdate()
            //der Klassen Statement oder PreparedStatement

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
