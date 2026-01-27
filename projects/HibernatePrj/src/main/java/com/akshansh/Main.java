package com.akshansh;

import com.akshansh.entity.Course;
import com.akshansh.entity.Department;
import com.akshansh.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
//        Department d1 = new Department("Computer Science", "Tech Hall", null);
//        Department d2 = new Department("Mathematics", "Science Building", null);
//        Department d3 = new Department("Physics", "Science Building", null);
//
//        Student s1 = new Student("Alice", "Johnson", 20, 3.8, d1, null);
//        Student s2 = new Student("Bob", "Smith", 22, 3.2, d1, null);
//        Student s3 = new Student("Carol", "White", 19, 3.9, d2, null);
//        Student s4 = new Student("David", "Brown", 21, 2.8, d1, null);
//        Student s5 = new Student("Eve", "Davis", 23, 3.5, d2, null);
//        Student s6 = new Student("Frank", "Miller", 20, 3.1, d3, null);
//        Student s7 = new Student("Grace", "Wilson", 22, 3.7, d3, null);
//
//        Course c1 = new Course("CS101", "Intro to Programming", 3, new HashSet<>(Set.of(s1, s2, s4)));
//        Course c2 = new Course("CS201", "Data Structures", 4, new HashSet<>(Set.of(s1, s2)));
//        Course c3 = new Course("MATH101", "Calculus I", 4, new HashSet<>(Set.of(s1, s3, s5)));
//        Course c4 = new Course("MATH201", "Linear Algebra", 3, new HashSet<>(Set.of(s3,s5)));
//        Course c5 = new Course("PHYS101", "Physics I", 4, new HashSet<>(Set.of(s6, s7)));
//        s1.setCourses(Set.of(c1, c2, c3));
//        s2.setCourses(Set.of(c1, c2));
//        s3.setCourses(Set.of(c3, c4));
//        s4.setCourses(Set.of(c1));
//        s5.setCourses(Set.of(c3, c4));
//        s6.setCourses(Set.of(c5));
//        s7.setCourses(Set.of(c5));
//
//        d1.setStudents(new HashSet<>(Set.of(s1, s2, s4)));
//        d2.setStudents(new HashSet<>(Set.of(s3, s5)));
//        d3.setStudents(new HashSet<>(Set.of(s6, s7)));

        Configuration cfg = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Course.class);

        try (SessionFactory sf = cfg.buildSessionFactory();
             Session session = sf.openSession()) {
            InstituteDAO dao = new InstituteDAO(session);

            List<Student> achievers = dao.findHighAchievers();
            System.out.println("=== HIGH ACHIEVERS ===");
            for (Student s : achievers) {
                System.out.println(s.getFirstName() + " " + s.getLastName() + " - GPA: " + s.getGpa());
            }

            Map<String, Long> map = dao.getStudentCountByDepartment();
            System.out.println("\n=== STUDENT COUNT PER DEPT ===");
            map.forEach((s, i) -> {
                System.out.println(s + ": " + i);
            });

            List<Student> csStudents = dao.findStudentsWithDepartment("Computer Science");
            System.out.println("\n=== STUDENTS PER DEPT ===");
            for (Student s : csStudents) {
                System.out.println(s.getFirstName() + " - Building: " +
                        s.getDepartment().getBuilding());
            }

            List<Object[]> results = dao.findStudentsWithMultipleCourses(2);
            System.out.println("\n=== STUDENTS WITH MULTIPLE COURSES ===");
            for (Object[] row : results) {
                String fullName = (String) row[0];
                Long courseCount = (Long) row[1];
                System.out.println(fullName + " - Courses: " + courseCount);
            }

            double avgBefore = dao.getAverageGpaByDepartment("Computer Science");
            System.out.println("\nAverage GPA before: " + avgBefore);

            Transaction tx = session.beginTransaction();
            int updated = dao.promoteStudents("Computer Science", 3.0);
            System.out.println("\nStudents promoted: " + updated);
            tx.commit();

            session.clear();

            double avgAfter = dao.getAverageGpaByDepartment("Computer Science");
            System.out.println("\nAverage GPA after: " + avgAfter);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}