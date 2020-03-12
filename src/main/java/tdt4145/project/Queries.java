package tdt4145.project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Queries extends DBConn {
    // 1) Finne navnet på alle rollene en gitt skuespiller har
    public void fetchRolesForPerson (String name) {
        System.out.println("\u001B[34mFetching roles.\u001B[0m");
        List<String> roles = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT rolle FROM SkuespillerI WHERE fnr=(SELECT Fnr FROM Person WHERE Navn=?)");
            stmt.setString(1, name);

            if (stmt.execute()) {
                ResultSet res = stmt.getResultSet();

                while (res.next()) {
                    roles.add(res.getString(1));
                }
            }

        } catch (SQLException e) {
            System.out.println(String.format("Error occured during fetchRolesForPerson: %s", e.getMessage()));
        }

        String opt = String.format("%s acts as:\n", name);
        for (String role : roles) {
            opt += String.format("- %s\n", role);
        }

        System.out.println(opt);
    }

    // 2) Finne hvilke filmer som en gitt skuespiller opptrer i.
    public void fetchMoviesForPerson (String name) {
        System.out.println("\u001B[34mFetching movies.\u001B[0m");
        List<String> movies = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT M.tittel FROM Person P " +
                    "INNER JOIN SkuespillerI S " +
                    "ON P.fnr = S.fnr " +
                    "INNER JOIN Media M " +
                    "ON S.MediaID = M.MediaID " +
                    "WHERE P.navn=?");
            stmt.setString(1, name);

            if (stmt.execute()) {
                ResultSet res = stmt.getResultSet();

                while (res.next()) {
                    movies.add(res.getString(1));
                }
            }

        } catch (SQLException e) {
            System.out.println(String.format("Error occured during fetchMoviesForPerson: %s", e.getMessage()));
        }

        String opt = String.format("%s appears in:\n", name);
        for (String movie : movies) {
            opt += String.format("- %s\n", movie);
        }

        System.out.println(opt);
    }

    // 3) Finne hvilke filmselskap som lager flest filmer innen hver sjanger ("Comedy", Action", "Romance"++)
    public void fetchTopCompaniesByGenres () {
        System.out.println("\u001B[34mFetching top companies for each genre.\u001B[0m");
        Map<String, List<String>> results = new HashMap<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT url, Sjanger, count(H.SjangerID) AS Total FROM Selskap S " +
                    "INNER JOIN EierAvMedia E " +
                    "ON E.SelskapID = S.SelskapID " +
                    "INNER JOIN Media M " +
                    "ON M.MediaID = E.MediaID " +
                    "INNER JOIN HarSjanger H " +
                    "ON H.MediaID = M.MediaID " +
                    "INNER JOIN Sjanger SJ " +
                    "ON SJ.SjangerID = H.SjangerID " +
                    "GROUP BY url, Sjanger " +
                    "ORDER BY Sjanger, Total DESC;");

            if (stmt.execute()) {
                ResultSet res = stmt.getResultSet();

                while(res.next()) {
                    List<String> values = new ArrayList<>();
                    values.add(res.getString(1));
                    values.add(res.getString(3));
                    results.put(res.getString(2), values);
                }
            }

            System.out.println(results);

        } catch (SQLException e) {
            System.out.println(String.format("Error occured during fetchTopCompaniesByGenres: %s", e.getMessage()));
        }

    }

    // 4) Sette inn en ny film med regissør, skuespillere og det som hører med.
    public void insertNewMovie () {
        System.out.println("\u001B[34mInserting new movie.\u001B[0m");

        /* INSERT CODE HERE */
    }

    // 5) Sette inn en ny anmeldelse av en episode av en serie.
    public void insertNewReview () {
        System.out.println("\u001B[34mInserting new review.\u001B[0m");

        /* INSERT CODE HERE*/
    }
}
