package com.application.daoTest;

import com.application.date.Date;
import com.application.entities.*;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

public class ParentDaoTest {

    private Parent actualParent;

    @Test
    public void test() {
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getSession();
        Student student = createStudent();
        StudentDao studentDao = new StudentDao(session);
        studentDao.save(student);
        actualParent = createParent(student);
        Assert.assertTrue(save(session));
        Assert.assertTrue(update(session));
        Assert.assertTrue(delete(session));
        studentDao.delete(student);
        session.close();
        HibernateUtil.shutdown();
    }

    private boolean save(Session session) {
        ParentDao parentDao = new ParentDao(session);

        parentDao.save(actualParent);

        Parent expectedParent = parentDao.findById(actualParent.getId());

        return actualParent.equals(expectedParent);
    }


    private boolean update(Session session) {
        ParentDao parentDao = new ParentDao(session);

        actualParent.setParentFullName("ФИО");
        actualParent.setFamilyStatus("полная");
        actualParent.setNumberChildren(2);
        actualParent.setPhoneNumber(22L);
        actualParent.setPlaceWork("Работа");

        parentDao.update(actualParent);

        Parent expectedParent = parentDao.findById(actualParent.getId());

        return actualParent.equals(expectedParent);
    }


    private boolean delete(Session session) {
        ParentDao parentDao = new ParentDao(session);

        parentDao.delete(actualParent);

        Parent parent = parentDao.findById(actualParent.getId());

        return parent == null;
    }

    private Parent createParent(Student student) {
        Parent parent = new Parent();
        parent.setParentFullName("ФИО");
        parent.setFamilyStatus("Полная");
        parent.setNumberChildren(123);
        parent.setPhoneNumber(4535L);
        parent.setPlaceWork("Место");
        parent.setAddress(createAddress());
        parent.setStudent(student);

        return parent;
    }

    private Student createStudent() {
        Student student = new Student();
        student.setStudentFullName("ФИО");
        student.setBirthDate(Date.createObjectDate("2001-03-20"));
        student.setPhoneNumber(4564L);
        student.setAddress(createAddress());
        student.setPassportData(createPassportData(student));
        student.setBirthCertificate(createBirthCertificate(student));

        return student;
    }

    private Address createAddress() {
        Address address = new Address();
        address.setCity("Улица");
        address.setStreet("Город");
        address.setHouseNumber(435);
        address.setFlatNumber(234);

        return address;
    }

    private BirthCertificate createBirthCertificate(Student student) {
        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificate.setSeries(6746);
        birthCertificate.setNumber(345634);
        birthCertificate.setIssuedBy("выдано");
        birthCertificate.setDateIssue(Date.createObjectDate("2001-03-20"));
        birthCertificate.setStudent(student);

        return birthCertificate;
    }

    private PassportData createPassportData(Student student) {
        PassportData passportData = new PassportData();
        passportData.setStudentFullName("ФИО");
        passportData.setBirthDate(Date.createObjectDate("2001-03-20"));
        passportData.setPlaceResidence("Место");
        passportData.setSeries(43534);
        passportData.setNumber(345345);
        passportData.setIssuedBy("Выдано");
        passportData.setDateIssue(Date.createObjectDate("2001-03-20"));
        passportData.setDepartmentCode(34634);
        passportData.setTin(3643L);
        passportData.setSnilsNumber(3453L);
        passportData.setStudent(student);

        return passportData;
    }
}
