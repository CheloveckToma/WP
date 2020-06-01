    package com.application.daoTest;

    import com.application.date.Date;
    import com.application.entities.*;
    import com.application.main.HibernateUtil;
    import org.hibernate.Session;
    import org.junit.Assert;
    import org.junit.Test;

    public class AttendanceDaoTest {

        private Attendance actualAttendance;

        @Test
        public void test() {
            HibernateUtil.buildSessionFactory();
            Session session = HibernateUtil.getSession();
            Student student = createStudent();
            StudentDao studentDao = new StudentDao(session);
            studentDao.save(student);
            actualAttendance = createAttendance(student);
            Assert.assertTrue(save(session));
            Assert.assertTrue(update(session));
            Assert.assertTrue(delete(session));
            studentDao.delete(student);
            session.close();
            HibernateUtil.shutdown();
        }

        private boolean save(Session session) {
            AttendanceDao attendanceDao = new  AttendanceDao(session);

            attendanceDao.save(actualAttendance);

            Attendance expectedAttendance =  attendanceDao.findById(actualAttendance.getId());

            return actualAttendance.equals(expectedAttendance);
        }


        private boolean update(Session session) {
            AttendanceDao attendanceDao = new AttendanceDao(session);

            actualAttendance.setHours(5);
            actualAttendance.setDate(Date.createObjectDate("2010-01-10"));

            attendanceDao.update(actualAttendance);

            Attendance expectedAttendance = attendanceDao.findById(actualAttendance.getId());

            return actualAttendance.equals(expectedAttendance);
        }


        private boolean delete(Session session) {
            AttendanceDao attendanceDao = new AttendanceDao(session);

            attendanceDao.delete(actualAttendance);

            Attendance attendance = attendanceDao.findById(actualAttendance.getId());

            return attendance == null;
        }

        private Attendance createAttendance(Student student) {
            Attendance attendance = new Attendance();
            attendance.setHours(5);
            attendance.setDate(Date.createObjectDate("2010-01-10"));
            attendance.setStudent(student);

            return attendance;
        }

        private Student createStudent() {
            Student student = new Student();
            student.setStudentFullName("ФИО");
            student.setBirthDate(Date.createObjectDate("1917-02-17"));
            student.setPhoneNumber(56234122L);
            student.setAddress(createAddress());
            student.setPassportData(createPassportData(student));
            student.setBirthCertificate(createBirthCertificate(student));

            return student;
        }


        private Address createAddress() {
            Address address = new Address();
            address.setCity("Город");
            address.setStreet("Улица");
            address.setHouseNumber(13);
            address.setFlatNumber(666);

            return address;
        }

        private BirthCertificate createBirthCertificate(Student student) {
            BirthCertificate birthCertificate = new BirthCertificate();
            birthCertificate.setSeries(234234);
            birthCertificate.setNumber(34523);
            birthCertificate.setIssuedBy("Выдан");
            birthCertificate.setDateIssue(Date.createObjectDate("1917-02-12"));
            birthCertificate.setStudent(student);

            return birthCertificate;
        }

        private PassportData createPassportData(Student student) {
            PassportData passportData = new PassportData();
            passportData.setStudentFullName("ФИО");
            passportData.setBirthDate(Date.createObjectDate("1917-02-18"));
            passportData.setPlaceResidence("Место");
            passportData.setSeries(12354);
            passportData.setNumber(23423);
            passportData.setIssuedBy("Выдано");
            passportData.setDateIssue(Date.createObjectDate("2020-02-12"));
            passportData.setDepartmentCode(54234);
            passportData.setTin(543L);
            passportData.setSnilsNumber(2236L);
            passportData.setStudent(student);

            return passportData;
        }
    }
