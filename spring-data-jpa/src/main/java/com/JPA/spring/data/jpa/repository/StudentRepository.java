package com.JPA.spring.data.jpa.repository;

import com.JPA.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.Style;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

     List<Student> findByFirstName(String firstName);

     List<Student> findByFirstNameContaining(String name);

     List<Student> findByLastNameNotNull();

     List<Student> findByGuardianName(String guardianName);

     //JPQL
     @Query("select s from Student s where s.emailId=?1")
     Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    // native query used for complex query
    @Query(
            value = "select * from tbl_student s where s.email_address=?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    // Native named param
    @Query(
            value = "select * from tbl_student s where s.email_address=:emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    // method to update the first name of student based on emailId
    @Modifying
    @Transactional
   // @Transactional annotation in spring boot JPA used to commit the Query after successful operation
    @Query(
            value="update tbl_student set first_name=?1 where email_address=?1",
            nativeQuery = true
    )
    //Student updateStudentNameByEmailId(String firstName,String emailId);
    int updateStudentNameByEmailId(String firstName,String emailId);
}
