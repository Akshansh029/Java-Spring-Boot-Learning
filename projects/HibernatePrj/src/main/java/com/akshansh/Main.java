package com.akshansh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        Parent p1 = new Parent(1, "Sunil", "Singh", 53);

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

            session.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
