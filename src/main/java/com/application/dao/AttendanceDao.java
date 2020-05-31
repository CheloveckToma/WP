package com.application.dao;

import com.application.entities.Attendance;
import com.application.entities.Subject;
import com.application.main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AttendanceDao {

    private Session session = HibernateUtil.getSession();

    public Attendance findById(int id) {
        return session.get(Attendance.class, id);
    }
    public List<Attendance> findAll() {
        return (List<Attendance>) HibernateUtil.getSessionFactory().openSession().createQuery("FROM Attendance").list();
    }

    public void save(Attendance attendance) {
        Transaction tr = session.beginTransaction();
        session.save(attendance);
        tr.commit();
        session.close();
    }

    public void update(Attendance attendance) {
        Transaction tr = session.beginTransaction();
        session.update(attendance);
        tr.commit();
        session.close();
    }

    public void delete(Attendance attendance) {
        Transaction tr = session.beginTransaction();
        session.delete(attendance);
        tr.commit();
        session.close();
    }
    public void closeSession() {
        if (session.isOpen())
            session.close();
    }
}
