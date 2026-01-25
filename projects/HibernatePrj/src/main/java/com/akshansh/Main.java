package com.akshansh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student(2, "Messi", 100);
        Student s2 = new Student(3, "Ronaldo", 90);
        Student s3 = new Student(4, "Cryuff", 94);
        Student s4 = new Student(5, "Zidane", 93);
        Student s5 = new Student(6, "Maradona", 97);
        Student s6 = new Student(7, "Pele", 93);

        Configuration cfg = new Configuration()
                                .addAnnotatedClass(com.akshansh.Student.class)
                                .configure();

        try(SessionFactory sf = cfg.buildSessionFactory()){
            StudentDAO dao = new StudentDAO(sf);
            dao.update(s2);

            System.out.println(dao.get(3));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
