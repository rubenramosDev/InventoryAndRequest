package edu.utl.rubenRamos.lasPalmasSystem.entity.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    private static String user = "ruben";
    private static String password = "password";
    private static Connection connection = null;

    public static Connection getDBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/las_palmas_db?serverTimezone=America/Mexico_City&useSSL=false", user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException sqlException) {
        }
    }

    public static Boolean isClosed() {
        try {
            return connection.isClosed();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
