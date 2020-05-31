package com.application.dao;

import com.application.entities.PassportData;
import com.application.entities.Subject;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PassportDataDao {

    private Session session = HibernateUtil.getSession();

    public PassportData findById(int id) {
        return session.get(PassportData.class, id);
    }

    public List<PassportData> findAll() {
        return (List<PassportData>) HibernateUtil.getSessionFactory().openSession().createQuery("FROM PassportData").list();
    }

    public void save(PassportData passportData) {
        Transaction tr = session.beginTransaction();
        session.save(passportData);
        tr.commit();
        session.close();
    }


    public void update(PassportData passportData) {
        Transaction tr = session.beginTransaction();
        session.update(passportData);
        tr.commit();
        session.close();
    }


    public void delete(PassportData passportData) {
        Transaction tr = session.beginTransaction();
        session.delete(passportData);
        tr.commit();
        session.close();
    }
    public void closeSession() {
        if (session.isOpen())
            session.close();
    }
}
