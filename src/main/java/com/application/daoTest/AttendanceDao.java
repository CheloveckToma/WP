package com.application.daoTest;

import com.application.entities.Attendance;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AttendanceDao {

    private Session session;

    public AttendanceDao(Session session) {
        this.session = session;
    }

    public Attendance findById(int id) {
        return session.get(Attendance.class, id);
    }

    public List<Attendance> findAll() {
        return session.createQuery("FROM Attendance").list();
    }

    public void save(Attendance attendance) {
        Transaction tr = session.beginTransaction();
        session.save(attendance);
        tr.commit();
    }

    public void update(Attendance attendance) {
        Transaction tr = session.beginTransaction();
        session.update(attendance);
        tr.commit();
    }

    public void delete(Attendance attendance) {
        Transaction tr = session.beginTransaction();
        session.delete(attendance);
        tr.commit();
    }
}