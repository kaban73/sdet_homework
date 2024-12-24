package lection_7;

import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement statement;
    public static void main(String[] args) {
        try {
            connect();
            readEx();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
            System.out.println("Connection is closed");
        }
    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        statement = connection.createStatement();
    }
    private static void disconnect() {
        try {
            if (connection != null) {
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTableEx() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (\n" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " name TEXT,\n" +
                " score INTEGER\n" +
                " );");
    }

    private static void dropTableEx() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS students;");
    }

    private static void readEx() throws SQLException {
        try (ResultSet rs = statement.executeQuery("SELECT * FROM students;")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " +
                        rs.getInt(3));
            }
        }
    }

    private static void clearTableEx() throws SQLException {
        statement.executeUpdate("DELETE FROM students;");
    }

    private static void deleteStudentForNameEx(String name) throws SQLException {
        statement.executeUpdate("DELETE FROM students WHERE name = '"+name+"';");
    }

    private static void insertStudentEx(String name, int score) throws SQLException {
        statement.executeUpdate("INSERT INTO students (name,score) VALUES ('"+name+"', "+score+");");
    }

    private static void psBatchEx() {
        try (PreparedStatement prepInsert = connection.prepareStatement("INSERT INTO students(name,score) VALUES(?,?)")) {
            for (int i = 1; i <= 10; i++) {
                prepInsert.setString(1, "Bob" + i);
                prepInsert.setInt(2, i * 10 % 100);
                prepInsert.addBatch();
            }
            prepInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void transactionEx() throws SQLException {
        connection.setAutoCommit(false);
        try {
            statement.execute("INSERT INTO students (name, score) values ('Walentin', 56)");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

}

