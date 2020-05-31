package com.application.dao;

import com.application.entities.Subject;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SubjectDao {

    private Session session = HibernateUtil.getSession();

    public Subject findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Subject.class, id);
    }


    public List<Subject> findAll() {
        return (List<Subject>) HibernateUtil.getSessionFactory().openSession().createQuery("FROM Subject").list();
    }


    public void save(Subject discipline) {
        Transaction tr = session.beginTransaction();
        session.save(discipline);
        tr.commit();
        session.close();
    }


    public void update(Subject discipline) {
        Transaction tr = session.beginTransaction();
        session.update(discipline);
        tr.commit();
        session.close();
    }


    public void delete(Subject discipline) {
        Transaction tr = session.beginTransaction();
        session.delete(discipline);
        tr.commit();
        session.close();
    }
}
