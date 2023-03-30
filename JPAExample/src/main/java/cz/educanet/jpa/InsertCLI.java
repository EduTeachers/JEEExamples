package cz.educanet.jpa;

import cz.educanet.jpa.entities.ArticleEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertCLI {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyArticleApp");
        EntityManager em = emf.createEntityManager();

        ArticleEntity entity = new ArticleEntity();
        entity.setTitle("Hello, world!");
        entity.setDescription("Test");
        entity.setBody("Test 123");

        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(entity);

        et.commit();

        em.close();
        emf.close();
    }

}
