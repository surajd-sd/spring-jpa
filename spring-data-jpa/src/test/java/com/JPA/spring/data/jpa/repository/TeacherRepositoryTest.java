package com.JPA.spring.data.jpa.repository;

import com.JPA.spring.data.jpa.entity.Course;
import com.JPA.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseJava=Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Course courseDba=Course.builder()
                .title("DBA")
                .credit(6)
                .build();


        Teacher teacher=Teacher.builder()
                .firstName("rahul")
                .lastName("barve")
                //.courses(List.of(courseJava,courseDba)) we commented this because we removed
                // reference of the course
                .build();

        teacherRepository.save(teacher);
    }
}