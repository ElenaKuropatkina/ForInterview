package lesson4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceCinema {

    private static Connection connection;
    private static Statement stmt;

    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useUnicode=true&serverTimezone=UTC",
                    "root", "Dasha5631304@");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getFilmTitleById(int id) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT title FROM films WHERE id = '" + id + "'");
            if (rs.next()) {
                String filmTitle = rs.getString(1);
                return filmTitle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getTimeFromSchedule() {
        List<String> dataTime = new ArrayList<String>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT sessions.time FROM schedules JOIN sessions ON sessions.id = schedules.id_session ORDER BY schedules.id");
            while (rs.next()) {
                String s = rs.getString(1);
                dataTime.add(s);
            }
            return dataTime;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Integer> getFilmLengthFromSchedule() {
        List<Integer> dataLenght = new ArrayList<Integer>();

        try {
            ResultSet rs = stmt.executeQuery("SELECT films.lenght, films.title FROM schedules JOIN films ON films.id = schedules.id_film ORDER BY schedules.id");
            while (rs.next()) {
                int s = rs.getInt(1);
                dataLenght.add(s);
            }
            return dataLenght;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
