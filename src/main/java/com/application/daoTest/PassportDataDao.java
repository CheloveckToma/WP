package com.application.daoTest;

import com.application.entities.PassportData;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PassportDataDao {

    private Session session;

    public PassportDataDao(Session session) {
        this.session = session;
    }

    public PassportData findById(int id) {
        return session.get(PassportData.class, id);
    }

    public List<PassportData> findAll() {
        return (List<PassportData>) session.createQuery("FROM PassportData").list();
    }

    public void save(PassportData passportData) {
        Transaction tr = session.beginTransaction();
        session.save(passportData);
        tr.commit();
    }

    public void update(PassportData passportData) {
        Transaction tr = session.beginTransaction();
        session.update(passportData);
        tr.commit();
    }

    public void delete(PassportData passportData) {
        Transaction tr = session.beginTransaction();
        session.delete(passportData);
        tr.commit();
    }
}
