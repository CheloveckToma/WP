package com.application.dao;

import com.application.entities.BirthCertificate;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BirthCertificateDao {

    private Session session = HibernateUtil.getSession();

    public BirthCertificate findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(BirthCertificate.class, id);
    }

    public List<BirthCertificate> findAll() {
        return (List<BirthCertificate>) HibernateUtil.getSessionFactory().openSession().createQuery("FROM BirthCertificate").list();
    }

    public void save(BirthCertificate birthCertificate) {
        Transaction tr = session.beginTransaction();
        session.save(birthCertificate);
        tr.commit();
        session.close();
    }


    public void update(BirthCertificate birthCertificate) {
        Transaction tr = session.beginTransaction();
        session.update(birthCertificate);
        tr.commit();
        session.close();
    }

    public void delete(BirthCertificate birthCertificate) {
        Transaction tr = session.beginTransaction();
        session.delete(birthCertificate);
        tr.commit();
        session.close();
    }
}
