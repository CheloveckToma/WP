package com.application.daoTest;

import com.application.entities.Subject;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SubjectDao {

    private Session session;

    public SubjectDao(Session session) {
        this.session = session;
    }

    public Subject findById(int id) {
        return session.get(Subject.class, id);
    }

    public List<Subject> findAll() {
        return (List<Subject>) session.createQuery("FROM Subject").list();
    }

    public void save(Subject subject) {
        Transaction tr = session.beginTransaction();
        session.save(subject);
        tr.commit();
    }

    public void update(Subject subject) {
        Transaction tr = session.beginTransaction();
        session.update(subject);
        tr.commit();
    }

    public void delete(Subject subject) {
        Transaction tr = session.beginTransaction();
        session.delete(subject);
        tr.commit();
    }
}
