package com.application.daoTest;

import com.application.entities.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {

    private Session session;

    public StudentDao(Session session) {
        this.session = session;
    }

    public Student findById(int id) {
        return session.get(Student.class, id);
    }

    public List<Student> findAll() {
        return (List<Student>) session.createQuery("FROM Student").list();
    }

    public void save(Student student) {
        Transaction tr = session.beginTransaction();
        session.save(student);
        tr.commit();
    }

    public void update(Student student) {
        Transaction tr = session.beginTransaction();
        session.update(student);
        tr.commit();
    }

    public void delete(Student student) {
        Transaction tr = session.beginTransaction();
        session.delete(student);
        tr.commit();
    }
}