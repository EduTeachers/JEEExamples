package cz.educanet.cli;

import java.sql.*;

public class SimpleInsertCLI {

    /* https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html */
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/blog?user=root&password=");

            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO article (title, description, body) VALUES ('Inserted text', 'My awesome description', '...')");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
