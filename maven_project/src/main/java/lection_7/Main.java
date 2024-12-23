package lection_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static Connection connection;
    public static void main(String[] args) {
        try {
            connect();
            System.out.println("Connection is opened");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
            System.out.println("Connection is closed");
        }
    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
    }
    private static void disconnect() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}