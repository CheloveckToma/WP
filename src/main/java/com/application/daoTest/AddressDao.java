package com.application.daoTest;

import com.application.entities.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AddressDao {
    private Session session;

    public AddressDao(Session session) {
        this.session = session;
    }

    public Address findById(int id) {
        return session.get(Address.class, id);
    }

    public List<Address> findAll() {
        return (List<Address>) session.createQuery("FROM Address").list();
    }

    public void save(Address address) {
        Transaction tr = session.beginTransaction();
        session.save(address);
        tr.commit();
    }

    public void update(Address address) {
        Transaction tr = session.beginTransaction();
        session.update(address);
        tr.commit();
    }

    public void delete(Address address) {
        Transaction tr = session.beginTransaction();
        session.delete(address);
        tr.commit();
    }
}

