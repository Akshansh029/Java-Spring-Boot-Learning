package com.akshansh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        Address add = new Address("252/1, Shantinagar", "Bishrampur", "Chhattisgarh", "India", "497226");
//        Parent p1 = new Parent(1, "Sunil", "Singh", 53, add);

        Laptop l1 = new Laptop(1, "Asus", "TUF F15", 16, null);
        Laptop l2 = new Laptop(2, "Dell", "XPS", 16, null);
        Laptop l3 = new Laptop(3, "HP", "Victus", 8, null);
        Student s1 = new Student(101, "Akshansh", 95, Arrays.asList(l1, l2));
        Student s2 = new Student(102, "Ayush", 92, Arrays.asList(l3));
        Student s3 = new Student(103, "Sourabh", 92, Arrays.asList(l2, l3));

        l1.setStudent(Arrays.asList(s1, s2));
        l2.setStudent(Arrays.asList(s1));
        l2.setStudent(Arrays.asList(s1,s2,s3));

        Configuration cfg = new Configuration()
                                .addAnnotatedClass(com.akshansh.Student.class)
                                .addAnnotatedClass(com.akshansh.Laptop.class)
                                .configure();

        try(SessionFactory sf = cfg.buildSessionFactory()){
            StudentDAO dao = new StudentDAO(sf);

            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.persist(l1);
            session.persist(l2);
            session.persist(l3);
            session.persist(s1);
            session.persist(s2);
            session.persist(s3);

            tx.commit();
            session.close();

            System.out.println(dao.get(101));
            System.out.println(dao.get(102));
            System.out.println(dao.get(103));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
