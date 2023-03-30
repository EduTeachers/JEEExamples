package cz.educanet.jpa;

import cz.educanet.jpa.entities.ArticleEntity;
import jakarta.persistence.*;

import java.util.List;

public class UpdateCLI {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyArticleApp");
        EntityManager em = emf.createEntityManager();

        TypedQuery<ArticleEntity> query = em.createQuery("SELECT article FROM ArticleEntity AS article WHERE articleId = :id", ArticleEntity.class);
        query.setParameter("id", 1);
        ArticleEntity result = query.getSingleResult();

        EntityTransaction et = em.getTransaction();
        et.begin();

        result.setTitle("Updated Article!");
        em.persist(result);

        et.commit();

        em.close();
        emf.close();
    }

}
