package com.akshansh;

import com.akshansh.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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

    public List<Student> getAll() {
        try (Session session = sf.openSession()) {
            String hql = "FROM Student";
            Query<Student> query = session.createQuery(hql, Student.class);
            return query.getResultList();
        }
    }

    public List<Student> getStudentByName(String name) {
        try (Session session = sf.openSession()) {
            String hql = "FROM Student s WHERE sName = :name";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("name", name);
            return query.getResultList();
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
