package com.application.daoTest;

import com.application.date.Date;
import com.application.entities.*;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

public class PerformanceDaoTest {

    private Performance actualPerformance;

    @Test
    public void test() {
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getSession();

        Student student = createStudent();
        StudentDao studentDao = new  StudentDao(session);
        studentDao.save(student);

        actualPerformance = createPerformance(student, session);
        Assert.assertTrue(save(session));
        Assert.assertTrue(update(session));
        Assert.assertTrue(delete(session));
        studentDao.delete(student);
        session.close();
        HibernateUtil.shutdown();
    }

    private boolean save(Session session) {
        PerformanceDao performanceDao = new PerformanceDao(session);

        performanceDao.save(actualPerformance);

        Performance expectedPerformance = performanceDao.findById(actualPerformance.getId());

        return actualPerformance.equals(expectedPerformance);
    }


    private boolean update(Session session) {
        PerformanceDao performanceDao = new PerformanceDao(session);

        actualPerformance.setMark(2);

        performanceDao.update(actualPerformance);

        Performance expectedPerformance = performanceDao.findById(actualPerformance.getId());

        return actualPerformance.equals(expectedPerformance);
    }


    private boolean delete(Session session) {
        PerformanceDao performanceDao = new  PerformanceDao(session);

        performanceDao.delete(actualPerformance);

        Performance performance = performanceDao.findById(actualPerformance.getId());

        return performance == null;
    }

    private Performance createPerformance(Student student, Session session) {
        Performance performance = new Performance();
        performance.setMark(5);
        performance.setStudent(student);

        SubjectDao subjectDao = new SubjectDao(session);

        Subject subject = subjectDao.findById(1);
        subject.addPerformance(performance);

        return performance;
    }

    private Student createStudent() {

        Student student = new Student();
        student.setStudentFullName("ФИО");
        student.setBirthDate(Date.createObjectDate("1999-01-19"));
        student.setPhoneNumber(231233123L);
        student.setAddress(createAddress());
        student.setPassportData(createPassportData(student));
        student.setBirthCertificate(createBirthCertificate(student));

        return student;
    }

    private Subject createSubject() {
        Subject subject = new Subject();
        subject.setSubjectName("Предмет");
        subject.setTeacherName("ФИО учителя");

        return subject;
    }

    private Address createAddress() {
        Address address = new Address();
        address.setCity("Город");
        address.setStreet("Улица");
        address.setHouseNumber(234);
        address.setFlatNumber(234);

        return address;
    }

    private BirthCertificate createBirthCertificate(Student student) {
        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificate.setSeries(643534);
        birthCertificate.setNumber(134354);
        birthCertificate.setIssuedBy("Выдано");
        birthCertificate.setDateIssue(Date.createObjectDate("1999-01-19"));
        birthCertificate.setStudent(student);

        return birthCertificate;
    }

    private PassportData createPassportData(Student student) {
        PassportData passportData = new PassportData();
        passportData.setStudentFullName("ФИО");
        passportData.setBirthDate(Date.createObjectDate("1999-01-19"));
        passportData.setPlaceResidence("Место");
        passportData.setSeries(34534);
        passportData.setNumber(345345);
        passportData.setIssuedBy("Выдано");
        passportData.setDateIssue(Date.createObjectDate("1999-01-19"));
        passportData.setDepartmentCode(456453);
        passportData.setTin(345345L);
        passportData.setSnilsNumber(34534L);
        passportData.setStudent(student);

        return passportData;
    }
}
