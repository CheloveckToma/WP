package com.application.dao;

import com.application.date.Date;
import com.application.entities.*;
import com.application.main.HibernateUtil;
import org.junit.Assert;
import org.junit.Test;

public class AttendanceDaoTest {


    @Test
    public void save() {
        HibernateUtil.buildSessionFactory();
        AttendanceDao attendanceDao = new AttendanceDao();
        Attendance attendance = createAttendanceObject();
        attendanceDao.save(attendance);
        Assert.assertTrue(attendance.equals(attendanceDao.findById(attendance.getId())));
        HibernateUtil.shutdown();
    }

    @Test
    public void update() {
        HibernateUtil.buildSessionFactory();
        AttendanceDao attendanceDao = new AttendanceDao();
        Attendance attendance = createAttendanceObject();
        attendanceDao.update(attendance);

        Attendance expectedAttendance = attendanceDao.findById(attendance.getId());
        Assert.assertTrue(attendance.equals(expectedAttendance));
    }

    @Test
    public void delete() {

    }

    private Attendance createAttendanceObject() {
        Attendance attendance = new Attendance();
        attendance.setDate(Date.createObjectDate("2008-02-03"));
        attendance.setHours(6);
        attendance.setStudent(createStudentObject());
        return attendance;
    }

    public Attendance changeAttendance(Attendance attendance) {
        attendance.setDate(Date.createObjectDate("2007-01-06"));
        attendance.setHours(8);
        attendance.setStudent(createStudentObject());
        return attendance;
    }

    private Student createStudentObject() {
        Student student = new Student();
        student.setStudentFullName("Владимир Лукьянов");
        student.setBirthDate(Date.createObjectDate("2001-01-01"));
        student.setPhoneNumber(792709557L);
        student.setAddress(createAddressObject());
        student.setBirthCertificate(createBirthCertificateObject());
        student.setPassportData(createPassportDataObject());

        StudentDao studentDao = new StudentDao();
        studentDao.save(student);

        return student;
    }

    private Address createAddressObject() {
        Address address = new Address();
        address.setCity("Город");
        address.setStreet("Улица");
        address.setHouseNumber(100);
        address.setFlatNumber(2);
        return address;
    }

    public BirthCertificate createBirthCertificateObject() {
        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificate.setSeries(32423);
        birthCertificate.setNumber(234234);
        birthCertificate.setIssuedBy("ООО манулы");
        birthCertificate.setDateIssue(Date.createObjectDate("2005-01-01"));
        return birthCertificate;
    }

    public PassportData createPassportDataObject() {
        PassportData passportData = new PassportData();
        passportData.setStudentFullName("Владимир Лукьянов");
        passportData.setBirthDate(Date.createObjectDate("2001-01-01"));
        passportData.setPlaceResidence("г. Пенза");
        passportData.setSeries(112551);
        passportData.setNumber(1234);
        passportData.setIssuedBy("ООО котики");
        passportData.setDateIssue(Date.createObjectDate("2019-01-01"));
        passportData.setDepartmentCode(3243);
        passportData.setTin(234423);
        passportData.setSnilsNumber(2343424);
        return passportData;
    }
}