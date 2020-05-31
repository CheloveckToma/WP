package com.application.dao;

import com.application.entities.Performance;
import com.application.entities.Subject;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PerformanceDao {
    private Session session = HibernateUtil.getSession();

    public Performance findById(int id) {
        return session.get(Performance.class, id);
    }

    public List<Performance> findAll() {
        return (List<Performance>) HibernateUtil.getSessionFactory().openSession().createQuery("FROM Performance").list();
    }

    public void save(Performance performance) {
        Transaction tr = session.beginTransaction();
        session.save(performance);
        tr.commit();
        session.close();
    }

    public void update(Performance performance) {
        Transaction tr = session.beginTransaction();
        session.update(performance);
        tr.commit();
        session.close();
    }

    public void delete(Performance performance) {
        Transaction tr = session.beginTransaction();
        session.delete(performance);
        tr.commit();
        session.close();
    }
    public void closeSession() {
        if (session.isOpen())
            session.close();
    }
}
