package tdt4145.project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println(String.format("Error occured during fetchRoles: %s", e.getMessage()));
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

        /* INSERT CODE HERE */
    }

    // 3) Finne hvilke filmselskap som lager flest filmer innen hver sjanger ("Comedy", Action", "Romance"++)
    public void fetchTopCompaniesByGenres () {
        System.out.println("\u001B[34mFetching top companies for each genre.\u001B[0m");

        /* INSERT CODE HERE */
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
