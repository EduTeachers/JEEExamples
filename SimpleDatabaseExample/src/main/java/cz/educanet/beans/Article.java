package cz.educanet.beans;

public class Article {

    private int articleId;
    private String title;
    private String description;
    private String body;

    public Article(int articleId, String title, String description, String body) {
        this.articleId = articleId;
        this.title = title;
        this.description = description;
        this.body = body;
    }

    public int getArticleId() {
        return articleId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBody() {
        return body;
    }
}
