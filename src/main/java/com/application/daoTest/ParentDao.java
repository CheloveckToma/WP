package com.application.daoTest;

import com.application.entities.Parent;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ParentDao  {

    private Session session;

    public ParentDao(Session session) {
        this.session = session;
    }

    public Parent findById(int id) {
        return session.get(Parent.class, id);
    }

    public List<Parent> findAll() {
        return (List<Parent>) session.createQuery("FROM Parent").list();
    }

    public void save(Parent parent) {
        Transaction tr = session.beginTransaction();
        session.save(parent);
        tr.commit();
    }

    public void update(Parent parent) {
        Transaction tr = session.beginTransaction();
        session.update(parent);
        tr.commit();
    }

    public void delete(Parent parent) {
        Transaction tr = session.beginTransaction();
        session.delete(parent);
        tr.commit();
    }
}
