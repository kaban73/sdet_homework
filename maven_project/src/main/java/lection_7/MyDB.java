package lection_7;

import java.sql.*;

public class MyDB {
    private Connection connection;
    private Statement statement;
    private final String nameDb;

    public MyDB(String nameDb) {
        this.nameDb = nameDb;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:"+nameDb+".db");
        statement = connection.createStatement();
        System.out.println("The connection is successful");
    }
    public void disconnect() {
        try {
            if (connection != null) {
                statement.close();
                connection.close();
                System.out.println("The connection is closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTableEx() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS cars (\n" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " model TEXT,\n" +
                " cost INTEGER\n" +
                " );");
    }
    public void dropTableEx() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS cars;");
    }
    public void readEx() throws SQLException {
        try (ResultSet rs = statement.executeQuery("SELECT * FROM cars;")) {
            System.out.println("Table contents:");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("model") + " " +
                        rs.getInt(3));
            }
            System.out.println("\n");
        }
    }
    public void clearTableEx() throws SQLException {
        statement.executeUpdate("DELETE FROM cars;");
    }
    public void deleteCarForModelEx(String model) throws SQLException {
        statement.executeUpdate("DELETE FROM cars WHERE model = '"+model+"';");
    }
    public void deleteCarForCostLess(int cost) throws SQLException {
        statement.executeUpdate("DELETE FROM cars WHERE cost < "+cost+";");
    }
    public void deleteCarForCostMore(int cost) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cars WHERE cost > ?");
        preparedStatement.setInt(1, cost);
        preparedStatement.executeUpdate();
    }
    public void insertCarEx(String model, int cost) throws SQLException {
        connection.setAutoCommit(false);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cars (model, cost) VALUES (?, ?);");
            preparedStatement.setString(1, model);
            preparedStatement.setInt(2, cost);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }
}

