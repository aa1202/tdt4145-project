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
        Map<String, List<List<String>>> results = new HashMap<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT S.navn, Sjanger, count(H.SjangerID) AS Total FROM Selskap S " +
                    "INNER JOIN EierAvMedia E " +
                    "ON E.SelskapID = S.SelskapID " +
                    "INNER JOIN Media M " +
                    "ON M.MediaID = E.MediaID " +
                    "INNER JOIN HarSjanger H " +
                    "ON H.MediaID = M.MediaID " +
                    "INNER JOIN Sjanger SJ " +
                    "ON SJ.SjangerID = H.SjangerID " +
                    "GROUP BY S.navn, Sjanger " +
                    "ORDER BY Sjanger, Total DESC;");

            if (stmt.execute()) {
                ResultSet res = stmt.getResultSet();

                while(res.next()) {
                    if (!results.containsKey(res.getString(2))) {
                        results.put(res.getString(2), new ArrayList<>());
                    }

                    List<String> values = new ArrayList<>();

                    values.add(res.getString(1));
                    values.add(res.getString(3));
                    results.get(res.getString(2)).add(values);
                }
            }

        } catch (SQLException e) {
            System.out.println(String.format("Error occured during fetchTopCompaniesByGenres: %s", e.getMessage()));
        }

        for (Map.Entry<String, List<List<String>>> entry : results.entrySet()) {
            System.out.println(String.format("\u001B[36m%s:\u001B[0m", entry.getKey()));

            for (List<String> e : entry.getValue()) {
                String name = e.get(0);
                Integer total = Integer.parseInt(e.get(1));
                System.out.println(String.format("- %s: %d %s", name, total, total > 1 ? "films" : "film" ));
            }
            System.out.println();
        }
    }

    // 4) Sette inn en ny film med regissør, skuespillere og det som hører med.
    public void insertNewMovie (List<List<String>> data) {
        System.out.println("\u001B[34mInserting new movie.\u001B[0m");

        // Movie
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Media (tittel, utgivelsesår, lanseringsdato, beskrivelse, lengde, selskapid) " +
                    "VALUES (?, ?, ?, ?, ?, (SELECT SelskapID from Selskap WHERE Navn=?))");

            stmt.setString(1, data.get(0).get(0));
            stmt.setString(2, data.get(0).get(1));
            stmt.setString(3, data.get(0).get(2));
            stmt.setString(4, data.get(0).get(3));
            stmt.setInt(5, Integer.parseInt(data.get(0).get(4)));
            stmt.setString(6, data.get(0).get(5));

            stmt.execute();
            System.out.println(String.format("%s added!", data.get(0).get(0)));

        } catch (SQLException e) {
            System.out.println(String.format("Error occured during movie insert: %s", e.getMessage()));
        }

        // Director
        try {
            for (String dir : data.get(1)) {
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO RegiAv (fnr, MediaID) VALUES ((SELECT fnr FROM Person WHERE navn=?), (SELECT MediaID FROM Media WHERE tittel=?))");
                stmt.setString(1, dir);
                stmt.setString(2, data.get(0).get(0));
                stmt.execute();

                System.out.println(String.format("%s added as director.", dir));
            }

        } catch (SQLException e) {
            System.out.println(String.format("Error occured during director insert: %s", e.getMessage()));
        }

        // Writer
        try {
            for (String wr : data.get(2)) {
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO SkrevetAv (fnr, MediaID) VALUES ((SELECT fnr FROM Person WHERE navn=?), (SELECT MediaID FROM Media WHERE tittel=?))");
                stmt.setString(1, wr);
                stmt.setString(2, data.get(0).get(0));
                stmt.execute();

                System.out.println(String.format("%s added as director.", wr));
            }

        } catch (SQLException e) {
            System.out.println(String.format("Error occured during writer insert: %s", e.getMessage()));
        }

        // Actor
        try {
            for (int i = 0; i < data.get(3).size(); i += 2) {
                PreparedStatement stmt = connection.prepareStatement("INSERT INTO SkuespillerI (fnr, MediaID, rolle) VALUES ((SELECT fnr FROM Person WHERE navn=?), (SELECT MediaID FROM Media WHERE tittel=?), ?)");
                stmt.setString(1, data.get(3).get(i));
                stmt.setString(2, data.get(0).get(0));
                stmt.setString(3, data.get(3).get(i+1));

                stmt.execute();

                System.out.println(String.format("%s added as actor.", data.get(3).get(i)));
            }

        } catch (SQLException e) {
            System.out.println(String.format("Error occured during actor insert: %s", e.getMessage()));
        }
    }

    // 5) Sette inn en ny anmeldelse av en episode av en serie.
    public void insertNewReview () {
        System.out.println("\u001B[34mInserting new review.\u001B[0m");

        /* INSERT CODE HERE*/
    }
}
