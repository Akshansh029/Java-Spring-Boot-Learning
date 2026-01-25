package com.akshansh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        Address add = new Address("252/1, Shantinagar", "Bishrampur", "Chhattisgarh", "India", "497226");
        Parent p1 = new Parent(1, "Sunil", "Singh", 53, add);

        Configuration cfg = new Configuration()
                                .addAnnotatedClass(com.akshansh.Parent.class)
                                .configure();

        try(SessionFactory sf = cfg.buildSessionFactory()){
//            StudentDAO dao = new StudentDAO(sf);
//            dao.update(s2);
//            System.out.println(dao.get(3));

            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.persist(p1);
            tx.commit();

            Parent p = session.find(Parent.class, 1);
            System.out.println(p);

            session.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
