package cz.educanet.jpa;

import cz.educanet.jpa.entities.ArticleEntity;
import cz.educanet.jpa.entities.UserEntity;
import jakarta.persistence.*;

import java.util.List;

public class SelectCLI {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyArticleApp");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();
        UserEntity karel = new UserEntity();
        karel.setFullName("Karel K");
        karel.setEmail("karel@karel.cz");
        em.persist(karel);

        ArticleEntity article = new ArticleEntity();
        article.setTitle("Title");
        article.setBody("Body");
        article.setDescription("Description");
        article.setAuthor(karel);
        em.persist(article);
        et.commit();

        // SELECT * FROM ArticleEntity JOIN UserEntity ON (ArticleEntity.author = UserEntity.userId)
        TypedQuery<ArticleEntity> query = em.createQuery("""
                SELECT article FROM ArticleEntity AS article
                JOIN FETCH article.author AS author
                """, ArticleEntity.class);
        List<ArticleEntity> result = query.getResultList();

        for (ArticleEntity entity : result) {
            System.out.println(entity.getAuthor().getFullName() + " – " + entity.getTitle());
        }

        em.close();
        emf.close();
    }

}
