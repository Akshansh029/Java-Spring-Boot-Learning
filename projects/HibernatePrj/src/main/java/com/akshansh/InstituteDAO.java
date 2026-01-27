package com.akshansh;

import com.akshansh.entity.Department;
import com.akshansh.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstituteDAO {
    private final Session session;

    public InstituteDAO(Session session){
        this.session = session;
    }

    public List<Student> findHighAchievers(){
        String hql = "FROM Student s WHERE s.gpa >= 3.5 ORDER BY s.gpa DESC";
        Query<Student> query = session.createQuery(hql, Student.class);
        return query.getResultList();
    }

    public Map<String, Long> getStudentCountByDepartment(){
        String hql = "SELECT s.department.name, COUNT(s) FROM Student s GROUP BY s.department.name";
        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> result = query.getResultList();
        Map<String, Long> map = new HashMap<>();

        for(Object[] row : result){
            String d = (String) row[0];
            Long c = (Long) row[1];
            map.put(d, c);
        }

        return map;
    }

    public List<Student> findStudentsWithDepartment(String dName){
        String hql = "FROM Student s JOIN FETCH s.department WHERE s.department.name = :dName";
        Query<Student> query = session.createQuery(hql, Student.class);
        query.setParameter("dName", dName);
        return query.getResultList();
    }

    public List<Object[]> findStudentsWithMultipleCourses(int minCourse){
        // Concatenate first and last name, join with courses, group by student, filter by count
        String hql = "SELECT CONCAT(s.firstName, ' ', s.lastName), COUNT(c) " +
                "FROM Student s JOIN s.courses c " +
                "GROUP BY s.id, s.firstName, s.lastName " +
                "HAVING COUNT(c) >= :minCourse";

        Query<Object[]> query = session.createQuery(hql, Object[].class);
        query.setParameter("minCourse", minCourse);
        return query.getResultList();
    }

    public double getAverageGpaByDepartment(String deptName){
        String hql = "SELECT AVG(s.gpa) FROM Student s WHERE s.department.name = :dName";
        Query<Double> query = session.createQuery(hql, Double.class);
        query.setParameter("dName", deptName);
        Double result = query.uniqueResult();
        return result != null ? result : 0.0;
    }

    public int promoteStudents(String deptName, double thres){
        String hql = "UPDATE Student s SET s.gpa = s.gpa + 0.2 WHERE s.gpa < :threshold AND s.department.name = :dName";
        Query query = session.createQuery(hql);
        query.setParameter("threshold", thres);
        query.setParameter("dName", deptName);
        return query.executeUpdate();
    }
}
