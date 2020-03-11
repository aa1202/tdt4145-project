package tdt4145.project;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Queries extends DBConn {
    public void fetchRoles(int fnr, int MediaID) {
        List<String> roles = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT Rolle FROM Skuespiller WHERE BesetningID  = ? GROUP BY Rolle")

        } catch (SQLException e) {
            System.out.println(String.format("Error occured during fetchRoles: %s", e.getMessage()));
        }
    }
}
