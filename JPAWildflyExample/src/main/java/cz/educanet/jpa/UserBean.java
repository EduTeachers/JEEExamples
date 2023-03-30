package cz.educanet.jpa;

import cz.educanet.jpa.entities.UserEntity;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Named
@ApplicationScoped
public class UserBean {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyUserApp");

    public void addUser() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        UserEntity user = new UserEntity();
        user.setFirstName("Karel");
        user.setLastName("Nový");
        em.persist(user);

        et.commit();
        em.close();
    }

    @PreDestroy
    public void onDestroy() {
        emf.close();
    }

}
