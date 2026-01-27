package com.akshansh;

import com.akshansh.entity.Course;
import com.akshansh.entity.Department;
import com.akshansh.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        Department d1 = new Department(1, "Computer Science", "Tech Hall", null);
        Department d2 = new Department(2, "Mathematics", "Science Building", null);
        Department d3 = new Department(3, "Physics", "Science Building", null);

        Student s1 = new Student(1, "Alice", "Johnson", 20, 3.8, d1, null);
        Student s2 = new Student(2, "Bob", "Smith", 22, 3.2, d1, null);
        Student s3 = new Student(3, "Carol", "White", 19, 3.9, d2, null);
        Student s4 = new Student(4, "David", "Brown", 21, 2.8, d1, null);
        Student s5 = new Student(5, "Eve", "Davis", 23, 3.5, d2, null);
        Student s6 = new Student(6, "Frank", "Miller", 20, 3.1, d3, null);
        Student s7 = new Student(7, "Grace", "Wilson", 22, 3.7, d3, null);

        Course c1 = new Course(1, "CS101", "Intro to Programming", 3, Set.of(s1, s2, s4));
        Course c2 = new Course(2, "CS201", "Data Structures", 4, Set.of(s1, s2));
        Course c3 = new Course(3, "MATH101", "Calculus I", 4, Set.of(s1, s3, s5));
        Course c4 = new Course(4, "MATH201", "Linear Algebra", 3, Set.of(s3,s5));
        Course c5 = new Course(5, "PHYS101", "Physics I", 4, Set.of(s6, s7));

        s1.setCourses(Set.of(c1, c2, c3));
        s2.setCourses(Set.of(c1, c2));
        s3.setCourses(Set.of(c3, c4));
        s4.setCourses(Set.of(c1));
        s5.setCourses(Set.of(c3, c4));
        s6.setCourses(Set.of(c5));
        s7.setCourses(Set.of(c5));

        Configuration cfg = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Course.class);

        try(SessionFactory sf = cfg.buildSessionFactory()){
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();

            session.persist(d1);
            session.persist(d2);
            session.persist(d3);
            session.persist(s1);
            session.persist(s2);
            session.persist(s3);
            session.persist(s4);
            session.persist(s5);
            session.persist(s6);
            session.persist(s7);
            session.persist(c1);
            session.persist(c2);
            session.persist(c3);
            session.persist(c4);
            session.persist(c5);

            tx.commit();
            session.close();
        } catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}