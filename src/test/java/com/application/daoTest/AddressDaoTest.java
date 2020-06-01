package com.application.daoTest;


import com.application.entities.Address;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

public class AddressDaoTest {

    private Address actualAddress;

    @Test
    public void test() {
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getSession();
        actualAddress = createAddress();
        Assert.assertTrue(save(session));
        Assert.assertTrue(update(session));
        Assert.assertTrue(delete(session));
        session.close();
        HibernateUtil.shutdown();
    }

    private boolean save(Session session) {
        AddressDao addressDao = new AddressDao(session);

        addressDao.save(actualAddress);

        Address expectedAddress = addressDao.findById(actualAddress.getId());

        return actualAddress.equals(expectedAddress);
    }


    private boolean update(Session session) {
        AddressDao addressDao = new AddressDao(session);
        actualAddress.setCity("город");
        actualAddress.setStreet("улица");
        actualAddress.setHouseNumber(4213);
        actualAddress.setFlatNumber(123);

        addressDao.update(actualAddress);

        Address expectedAddress = addressDao.findById(actualAddress.getId());

        return actualAddress.equals(expectedAddress);
    }


    private boolean delete(Session session) {
        AddressDao addressDao = new AddressDao(session);

        addressDao.delete(actualAddress);

        Address address = addressDao.findById(actualAddress.getId());

        return address == null;
    }

    private Address createAddress() {
        Address address = new Address();
        address.setCity("Город");
        address.setStreet("Улица");
        address.setHouseNumber(234);
        address.setFlatNumber(23);

        return address;
    }
}