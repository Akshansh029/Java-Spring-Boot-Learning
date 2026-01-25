package com.akshansh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    static public void addStudent(SessionFactory sf, Student s){
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(s);
        System.out.println(s + " inserted successfully!");
        tx.commit();
        session.close();
    }

    static public void getStudent(SessionFactory sf, int rno){
        Session session = sf.openSession();
        Student s = session.find(Student.class, rno);

        System.out.println("Required student: " + s);
        session.close();
    }

    public static void main(String[] args) {
        Student s1 = new Student(2, "Messi", 100);
        Student s2 = new Student(3, "Ronaldo", 89);
        Student s3 = new Student(4, "Cryuff", 94);
        Student s4 = new Student(5, "Zidane", 93);
        Student s5 = new Student(6, "Maradona", 97);
        Student s6 = new Student(7, "Pele", 93);

        Configuration cfg = new Configuration()
                                .addAnnotatedClass(com.akshansh.Student.class)
                                .configure();

        try(SessionFactory sf = cfg.buildSessionFactory()){
//            addStudent(sf, s1);
//            addStudent(sf, s2);
//            addStudent(sf, s3);
//            addStudent(sf, s4);
//            addStudent(sf, s5);
//            addStudent(sf, s6);

            getStudent(sf, 2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
