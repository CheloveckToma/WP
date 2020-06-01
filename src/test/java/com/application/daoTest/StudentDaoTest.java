package com.application.daoTest;


import com.application.date.Date;
import com.application.entities.Address;
import com.application.entities.BirthCertificate;
import com.application.entities.PassportData;
import com.application.entities.Student;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

public class StudentDaoTest {

    private Student actualStudent;

    @Test
    public void test() {
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getSession();
        actualStudent = createStudent();
        Assert.assertTrue(save(session));
        Assert.assertTrue(update(session));
        Assert.assertTrue(delete(session));
        session.close();
        HibernateUtil.shutdown();
    }

    private boolean save(Session session) {
        StudentDao studentDao = new StudentDao(session);

        studentDao.save(actualStudent);

        Student expectedStudent = studentDao.findById(actualStudent.getId());

        return actualStudent.equals(expectedStudent);
    }


    private boolean update(Session session) {
        StudentDao studentDao = new StudentDao(session);

        actualStudent.setStudentFullName("ФИО");
        actualStudent.setBirthDate(Date.createObjectDate("1999-01-25"));
        actualStudent.setPhoneNumber(3656242L);

        studentDao.update(actualStudent);

        Student expectedStident = studentDao.findById(actualStudent.getId());

        return actualStudent.equals(expectedStident);
    }


    private boolean delete(Session session) {
        StudentDao studentDao = new StudentDao(session);

        studentDao.delete(actualStudent);

        Student performance = studentDao.findById(actualStudent.getId());

        return performance == null;
    }

    private Student createStudent() {
        Student student = new Student();
        student.setStudentFullName("ФИО");
        student.setBirthDate(Date.createObjectDate("1999-01-25"));
        student.setPhoneNumber(5462423L);
        student.setAddress(createAddress());
        student.setPassportData(createPassportData(student));
        student.setBirthCertificate(createBirthCertificate(student));

        return student;
    }

    private Address createAddress() {
        Address address = new Address();
        address.setCity("Город");
        address.setStreet("Улица");
        address.setHouseNumber(32);
        address.setFlatNumber(23);

        return address;
    }

    private BirthCertificate createBirthCertificate(Student student) {
        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificate.setSeries(532412);
        birthCertificate.setNumber(123412);
        birthCertificate.setIssuedBy("Выдано");
        birthCertificate.setDateIssue(Date.createObjectDate("1999-01-25"));
        birthCertificate.setStudent(student);

        return birthCertificate;
    }

    private PassportData createPassportData(Student student) {
        PassportData passportData = new PassportData();
        passportData.setStudentFullName("ФИО");
        passportData.setBirthDate(Date.createObjectDate("1999-01-25"));
        passportData.setPlaceResidence("Место");
        passportData.setSeries(32423);
        passportData.setNumber(234234);
        passportData.setIssuedBy("Выдано");
        passportData.setDateIssue(Date.createObjectDate("1999-01-25"));
        passportData.setDepartmentCode(2141242);
        passportData.setTin(1233L);
        passportData.setSnilsNumber(23423L);
        passportData.setStudent(student);

        return passportData;
    }
}
