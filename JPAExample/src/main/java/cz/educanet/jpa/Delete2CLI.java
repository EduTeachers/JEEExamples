package cz.educanet.jpa;

import cz.educanet.jpa.entities.ArticleEntity;
import jakarta.persistence.*;

public class Delete2CLI {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyArticleApp");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query = em.createQuery("DELETE FROM ArticleEntity WHERE articleId = :id");
        query.setParameter("id", 2);
        int updatedRows = query.executeUpdate();
        System.out.println(updatedRows);

        et.commit();

        em.close();
        emf.close();
    }

}
