package com.application.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "performance")
public class Performance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "mark")
    private int mark;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student")
    private Student student;

    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "subject")
    private Subject subject;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}




