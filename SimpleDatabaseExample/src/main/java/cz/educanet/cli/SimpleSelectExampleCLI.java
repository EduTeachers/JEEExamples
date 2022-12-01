package cz.educanet.cli;

import java.sql.*;

public class SimpleSelectExampleCLI {

    /* https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html */
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/blog?user=root&password=");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM article");



            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // TWR Example
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/blog?user=root&password=");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM article")
        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println("-----");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
