package com.application.dao;

import com.application.entities.Address;
import com.application.entities.Subject;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AddressDao {

    private Session session = HibernateUtil.getSession();

    public Address findById(int id) {
        return session.get(Address.class, id);
    }

    public List<Address> findAll() {
        return (List<Address>) HibernateUtil.getSessionFactory().openSession().createQuery("FROM Address").list();
    }

    public void save(Address address) {
        Transaction tr = session.beginTransaction();
        session.save(address);
        tr.commit();
        session.close();
    }

    public void update(Address address) {
        Transaction tr = session.beginTransaction();
        session.update(address);
        tr.commit();
        session.close();
    }

    public void delete(Address address) {
        Transaction tr = session.beginTransaction();
        session.delete(address);
        tr.commit();
        session.close();
    }

    public void closeSession() {
        if (session.isOpen())
            session.close();
    }
}
