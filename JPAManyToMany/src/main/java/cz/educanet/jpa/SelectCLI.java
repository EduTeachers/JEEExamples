package cz.educanet.jpa;

import cz.educanet.jpa.entities.StudentEntity;
import cz.educanet.jpa.entities.SubjectEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

public class SelectCLI {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyArticleApp");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();
        /*SubjectEntity programming = new SubjectEntity();
        programming.setName("PRG");
        em.persist(programming);

        SubjectEntity web = new SubjectEntity();
        web.setName("WEB");
        em.persist(web);*/

        SubjectEntity programming = em.find(SubjectEntity.class, 1);
        SubjectEntity web = em.find(SubjectEntity.class, 2);
        StudentEntity karel = new StudentEntity();
        karel.setFullName("Karel Nový");
        karel.setSubjects(List.of(programming, web));
        em.persist(karel);
        et.commit();

        TypedQuery<SubjectEntity> query = em.createQuery("""
                SELECT subject FROM SubjectEntity AS subject
                JOIN FETCH subject.students
                """, SubjectEntity.class);
        List<SubjectEntity> result = query.getResultList();

        for (SubjectEntity entity : result) {
            String students = entity.getStudents().stream().map(StudentEntity::getFullName).collect(Collectors.joining(", "));
            System.out.println(entity.getName() + " – " + students);
        }

        em.close();
        emf.close();
    }

}
