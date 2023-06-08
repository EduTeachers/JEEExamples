package cz.educanet.jpa.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subjectId;

    @Column
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<StudentEntity> students;

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}
