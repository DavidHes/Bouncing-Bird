import java.util.ArrayList;

public interface BouncingBirdDAO {

    void setterMethode(String typ, String pfad);
    String getterMethode(String typ);

    ArrayList<String> getScoreboard();
    void setScore(String name, int score);

}
