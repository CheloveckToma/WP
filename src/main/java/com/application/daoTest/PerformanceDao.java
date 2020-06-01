package com.application.daoTest;

import com.application.entities.Performance;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PerformanceDao {
    private Session session;

    public PerformanceDao(Session session) {
        this.session = session;
    }

    public Performance findById(int id) {
        return session.get(Performance.class, id);
    }

    public List<Performance> findAll() {
        return (List<Performance>) session.createQuery("FROM Performance").list();
    }

    public void save(Performance performance) {
        Transaction tr = session.beginTransaction();
        session.save(performance);
        tr.commit();
    }

    public void update(Performance performance) {
        Transaction tr = session.beginTransaction();
        session.update(performance);
        tr.commit();
    }

    public void delete(Performance performance) {
        Transaction tr = session.beginTransaction();
        session.delete(performance);
        tr.commit();
    }
}
