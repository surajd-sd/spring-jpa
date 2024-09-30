package com.JPA.spring.data.jpa.repository;

import com.JPA.spring.data.jpa.entity.Course;
import com.JPA.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    public void printCourses(){

        List<Course> courses=courseRepository.findAll();
        System.out.println("course = "+courses);
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher=Teacher.builder()
                .firstName("gaurav")
                .lastName("singh")
                .build();

        Course course=Course.builder()
                .title("python")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    // we will learn Pagination and sorting below

    public void findAllPagination(){
        Pageable firstPageWithThreeRecords= PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords= PageRequest.of(1,2);

        List<Course> courses=courseRepository.findAll(firstPageWithThreeRecords).getContent();
        System.out.println("Courses = "+courses);
    }
}
/*
 When we fetch the courses then we want to fetch the course material as well from this course
 repository we want to fetch course material also, so we go to our Course entity
*/