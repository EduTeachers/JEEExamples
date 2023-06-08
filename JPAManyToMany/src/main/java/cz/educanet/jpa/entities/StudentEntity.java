package cz.educanet.jpa.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;

    @Column
    private String fullName;

    @ManyToMany
    private List<SubjectEntity> subjects;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
    }
}
