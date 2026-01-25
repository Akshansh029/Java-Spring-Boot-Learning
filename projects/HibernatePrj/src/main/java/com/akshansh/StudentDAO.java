package com.akshansh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {

    private final SessionFactory sf;

    public StudentDAO(SessionFactory sf) {
        this.sf = sf;
    }

    public void add(Student s) {
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(s);
            tx.commit();
        }
    }

    public Student get(int id) {
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            Student s = session.find(Student.class, id);
            tx.commit();
            return s;
        }
    }

    public void update(Student s){
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(s);
            tx.commit();
        }
    }

    public void delete(int id){
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            Student s = session.find(Student.class, id);
            session.remove(s);
            tx.commit();
        }
    }
}
