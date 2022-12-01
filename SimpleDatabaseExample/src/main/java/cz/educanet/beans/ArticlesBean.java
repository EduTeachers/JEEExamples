package cz.educanet.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ArticlesBean {

    public List<Article> getArticles() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/blog?user=root&password=");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM article")
        ) {
            ArrayList<Article> articles = new ArrayList<>();

            while (resultSet.next()) {
                articles.add(new Article(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));
            }

            return articles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
