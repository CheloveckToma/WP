package com.application.daoTest;

import com.application.entities.BirthCertificate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BirthCertificateDao {

    private Session session;

    public BirthCertificateDao(Session session) {
        this.session = session;
    }

    public BirthCertificate findById(int id) {
        return session.get(BirthCertificate.class, id);
    }

    public List<BirthCertificate> findAll() {
        return (List<BirthCertificate>) session.createQuery("FROM BirthCertificate").list();
    }

    public void save(BirthCertificate birthCertificate) {
        Transaction tr = session.beginTransaction();
        session.save(birthCertificate);
        tr.commit();
    }

    public void update(BirthCertificate birthCertificate) {
        Transaction tr = session.beginTransaction();
        session.update(birthCertificate);
        tr.commit();
    }

    public void delete(BirthCertificate birthCertificate) {
        Transaction tr = session.beginTransaction();
        session.delete(birthCertificate);
        tr.commit();
    }
}
