package cz.educanet.jpa;

import cz.educanet.jpa.entities.ArticleEntity;
import jakarta.persistence.*;

import java.util.List;

public class SelectCLI {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyArticleApp");
        EntityManager em = emf.createEntityManager();

        // SELECT * FROM ArticleEntity
        TypedQuery<ArticleEntity> query = em.createQuery("SELECT article FROM ArticleEntity AS article", ArticleEntity.class);
        List<ArticleEntity> result = query.getResultList();

        for (ArticleEntity entity : result) {
            System.out.println(entity.getArticleId() + " – " + entity.getTitle());
        }

        em.close();
        emf.close();
    }

}
