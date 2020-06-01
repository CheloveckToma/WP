package com.application.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "subject")
    private String subjectName;

    @Column(name = "teacher")
    private String teacherName;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Performance> performance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }


    public List<Performance> getPerformance() {
        return performance;
    }

    public void setPerformance(List<Performance> performance) {
        this.performance = performance;
    }

    public void addPerformance(Performance performance) {
        performance.setSubject(this);
        this.performance.add(performance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != obj.getClass())
            return false;

        Subject subject = (Subject) obj;
        return id.equals(subject.id)&&
                Objects.equals(subjectName, subject.subjectName) &&
                Objects.equals(teacherName, subject.teacherName);
    }
}




