package com.akshansh.springjdbcexample.repository;

import com.akshansh.springjdbcexample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql = "INSERT INTO student (roll_no, name, marks) VALUES (?,?,?)";

        int rows = jdbc.update(sql, s.getRollno(), s.getName(), s.getMarks());
        System.out.println(rows + " affected");
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM student";

        RowMapper<Student> mapper = (rs, rowNum) -> {
            Student s = new Student();
            s.setRollNo(rs.getInt("roll_no"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));

            return s;
        };

        return jdbc.query(sql, mapper);
    }
}
