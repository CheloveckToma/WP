package com.application.daoTest;

import com.application.entities.Subject;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

public class SubjectDaoTest {

    private Subject subject;

    @Test
    public void test() {
        HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.getSession();
        subject = createSubject();
        Assert.assertTrue(save(session));
        Assert.assertTrue(update(session));
        Assert.assertTrue(delete(session));
        session.close();
        HibernateUtil.shutdown();
    }

    private boolean save(Session session) {
        SubjectDao subjectDao = new SubjectDao(session);

        subjectDao.save(subject);

        Subject expectedSubject = subjectDao.findById(subject.getId());

        return subject.equals(expectedSubject);
    }


    private boolean update(Session session) {
        SubjectDao subjectDao = new SubjectDao(session);

        subject.setSubjectName("Предмет");
        subject.setTeacherName("Учитель");

        subjectDao.update(subject);

        Subject expectedSubject = subjectDao.findById(subject.getId());

        return subject.equals(expectedSubject);
    }


    private boolean delete(Session session) {
        SubjectDao subjectDao = new  SubjectDao(session);

        subjectDao.delete(subject);

        Subject subject = subjectDao.findById(this.subject.getId());

        return subject == null;
    }

    private Subject createSubject() {
        Subject subject = new Subject();
        subject.setSubjectName("Предмет");
        subject.setTeacherName("ФИО учителя");

        return subject;
    }
}
