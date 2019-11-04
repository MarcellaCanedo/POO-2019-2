package config;

import java.sql.*;

public class SQLConnection {

    // add SET GLOBAL time_zone = '-3:00';

    private static java.sql.Connection conn = null;

    public static Connection getConnection() {

        if(conn == null) {

            try {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost/garagem-2.0","postgres","root");
            } catch (SQLException e) {
                // handle any errors
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }

            return conn;

        } else {
            return conn;
        }

    }

}
