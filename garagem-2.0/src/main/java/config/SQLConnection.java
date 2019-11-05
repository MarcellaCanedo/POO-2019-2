package config;

import java.sql.*;

public class SQLConnection {

    private static java.sql.Connection conn = null;

    public static Connection getConnection() {

        if(conn == null) {

            try {
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/garagem?autoReconnect=true&useSSL=false","root","root");
            } catch (SQLException e) {
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