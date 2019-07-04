package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

    String url = "jdbc:mysql://localhost:3306/java_class?useSSL=false";
    String username = "class";
    String password = "classprojects";

    Connection connection = null;

    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPrepareStatement(String query) throws SQLException{
        return connection.prepareStatement(query);
    }
}