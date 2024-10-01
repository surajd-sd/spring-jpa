package com.JPA.spring.data.jpa.repository;

import com.JPA.spring.data.jpa.entity.Course;
import com.JPA.spring.data.jpa.entity.CourseMaterial;
import com.JPA.spring.data.jpa.entity.Student;
import com.JPA.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseMaterial(){

        Course course=Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterials=courseMaterialRepository.findAll();
        System.out.println("Course material = " +courseMaterials);
    }

    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher=Teacher.builder()
                .firstName("Robert")
                .lastName("morgan")
                .build();

        Student student=Student.builder()
                .firstName("abhishek")
                .lastName("pandey")
                .emailId("abhishek@gmail.com")
                .build();

        Course course= Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}
 /* we will see cascading property --> it means to pass the properties or permission to our child
  from our parent, here in above program we have to save the courseMaterial but before that we
  have to save our "Course course=Course.builder()" this object "course", after that we will be
  able to save our courseMaterial so we will cascade the information, so In our CourseMaterial
  class we will be define cascade in @OneToOne annotation. */