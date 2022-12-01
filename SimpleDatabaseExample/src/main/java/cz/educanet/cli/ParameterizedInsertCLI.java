package cz.educanet.cli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ParameterizedInsertCLI {

    /* https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please fill in title, description and body.");
        String title = sc.nextLine();
        String description = sc.nextLine();
        String body = sc.nextLine();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/blog?user=root&password=");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO article (title, description, body) VALUES (?, ?, ?)"
            );

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, body);

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
