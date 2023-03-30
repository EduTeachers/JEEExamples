package cz.educanet.jpa;

import cz.educanet.jpa.entities.ArticleEntity;
import jakarta.persistence.*;

public class Update2CLI {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyArticleApp");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query = em.createQuery("UPDATE ArticleEntity SET title = :title WHERE articleId = :id");
        query.setParameter("title", "Updated title!");
        query.setParameter("id", 3);
        query.executeUpdate();

        et.commit();

        em.close();
        emf.close();
    }

}
