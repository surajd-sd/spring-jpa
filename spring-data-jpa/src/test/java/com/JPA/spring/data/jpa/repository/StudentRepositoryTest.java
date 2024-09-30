package com.JPA.spring.data.jpa.repository;

import com.JPA.spring.data.jpa.entity.Guardian;
import com.JPA.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    public void saveStudent(){
        Student student=Student.builder()
                .emailId("surajdubey@gmail.com")
                .firstName("suraj")
                .lastName("dubey")
//                .guardianName("ram")
//                .guardianEmail("ram@gmail.com")
//                .guardianMobile("99999")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printAllStudents(){
      List<Student> studentList=  studentRepository.findAll();
      System.out.println("student list = "+studentList);

    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian=Guardian.builder()
                        .email("satish@gmail.com")
                        .mobile("8888")
                        .name("satish")
                        .build();
        Student student=Student.builder()
                .firstName("pankaj")
                .emailId("pankaj@gmail.com")
                .lastName("dubey")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public  void printStudentByFirstName(){
        List<Student> students=studentRepository.findByFirstName("pankaj");
        System.out.println("Students = "+students);
    }

    @Test
    public  void printStudentByFirstNameContaining(){
        List<Student> students=studentRepository.findByFirstNameContaining("pa");
        System.out.println("Students = "+students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students=studentRepository.findByGuardianName("satish");
        System.out.println("student = "+students);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student=studentRepository.getStudentByEmailAddress("pankaj@gmail.com");
        System.out.println("student = "+student);
    }
    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName=studentRepository.getStudentFirstNameByEmailAddress("pankaj@gmail.com");
        System.out.println("student = "+firstName);
    }
    // Native Query
    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student=studentRepository.getStudentByEmailAddressNative("pankaj@gmail.com");
        System.out.println("student = "+student);
    }

    // Native Query param
    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student=studentRepository.getStudentByEmailAddressNativeNamedParam("pankaj@gmail.com");
        System.out.println("student = "+student);
    }

    // @Transactional query
    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("rohit","pankaj@fmail.com");
    }

}