package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    static String dbHost = "localhost";
    static String dbPort = "5432";
    static String dbName = "enigmamart_db";
    static String dbUser = "";
    static String dbPassword = "";
    static String dbUrl = String.format("jdbc:postgresql://%s:%s/%s", dbHost, dbPort, dbName);

    Connection connection;

    public Connection connect() {
        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Connect to database");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }

    public void close() {
        try {
            connection.close();
            System.out.println("Connection is shutdown ...");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


}
