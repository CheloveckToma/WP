package com.application.dao;

import com.application.entities.Student;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {

    private Session session = HibernateUtil.getSession();


    public Student findById(int id) {
        return session.get(Student.class, id);
    }

    public List<Student> findAll() {
        return (List<Student>) HibernateUtil.getSessionFactory().openSession().createQuery("FROM Student").list();
    }

    public void save(Student student) {
        Transaction tr =session .beginTransaction();
        session.save(student);
        tr.commit();
        session.close();
    }

    public void update(Student student) {
        Transaction tr = session.beginTransaction();
        session.update(student);
        tr.commit();
        session.close();
    }

    public void delete(Student student) {
        Transaction tr = session.beginTransaction();
        session.delete(student);
        tr.commit();
        session.close();
    }
    public void closeSession() {
        if (session.isOpen())
            session.close();
    }
}
