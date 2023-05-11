package cz.educanet.jpa.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long articleId;

    @Column
    private String fullName;

    @Column
    private String email;

    @OneToMany(mappedBy = "author")
    private List<ArticleEntity> articles;

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ArticleEntity> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleEntity> articles) {
        this.articles = articles;
    }
}
