package com.application.dao;

import com.application.entities.Parent;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ParentDao  {

    private Session session = HibernateUtil.getSession();

    public Parent findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Parent.class, id);
    }


    public List<Parent> findAll() {
        return (List<Parent>) HibernateUtil.getSessionFactory().openSession().createQuery("FROM Parent").list();
    }


    public void save(Parent parent) {
        Transaction tr = session.beginTransaction();
        session.save(parent);
        tr.commit();
        session.close();
    }


    public void update(Parent parent) {
        Transaction tr = session.beginTransaction();
        session.update(parent);
        tr.commit();
        session.close();
    }

    public void delete(Parent parent) {
        Transaction tr = session.beginTransaction();
        session.delete(parent);
        tr.commit();
        session.close();
    }
}
