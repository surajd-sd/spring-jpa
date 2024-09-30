package com.JPA.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

// we will do relation here @OneToOne,@OneToMany etc...
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"

    )
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudents(Student student){
        if(students==null) students=new ArrayList<>();
        /*
        This above line checks if the students list has been initialized. If it hasn't
        (students is null), it initializes a new ArrayList to store Student objects.
        This prevents a NullPointerException when trying to add a student to a list that
        hasn't been created yet.
        */

        students.add(student);
        /*
          After ensuring the students list is initialized, this line adds the provided
          Student object to the list.
         */
    }
}
/* for @ManyToMany relation a 3rd table get created, for example a many student have many courses
   then we should have to create a 3rd table which will contain the information about the studentId
   and a courseId therefore we use @JoinTable */

/*
  We use "inverseJoinColumns" for vice versa i.e. in previously we use "joinColumns" for our "many
  students have many courses" and now we want "many courses have many students" so for this we use
  "inverseJoinColumns"
*/

/*
  @JoinColumn is used to make the columns in the table as foreign key;
 */