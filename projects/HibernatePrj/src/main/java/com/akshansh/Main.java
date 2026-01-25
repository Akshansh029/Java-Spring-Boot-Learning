package com.akshansh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Akshansh", 95);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.akshansh.Student.class);
        cfg.configure();

        try(SessionFactory sf = cfg.buildSessionFactory()){
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.persist(s1);
            tx.commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
