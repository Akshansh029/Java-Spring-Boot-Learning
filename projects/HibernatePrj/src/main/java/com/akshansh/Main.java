package com.akshansh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Akshansh", 95);

        Configuration cfg = new Configuration();

        try(SessionFactory sf = cfg.buildSessionFactory()){
            cfg.configure();

            Session session = sf.openSession();
            session.persist(s1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
