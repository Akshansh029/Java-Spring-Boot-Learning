package com.akshansh.springjdbcexample;

import com.akshansh.springjdbcexample.model.Student;
import com.akshansh.springjdbcexample.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExampleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcExampleApplication.class, args);

        Student s1 = context.getBean(Student.class);
        s1.setRollNo(102);
        s1.setName("Sourabh");
        s1.setMarks(95);

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(s1);

        List<Student> students = service.getStudents();
        students.forEach(System.out::println);
    }
}
