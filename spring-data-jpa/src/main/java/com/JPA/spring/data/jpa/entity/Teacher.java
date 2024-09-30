package com.JPA.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

//    @OneToMany(
//            cascade = CascadeType.ALL
//    )
//    /*
//      @JoinColumn This will tell us the Course table will have a Column named (Fk)teacherId so that
//      we will get to know that which course is taught by which teacher
//    */
//    @JoinColumn(
//          name = "teacher_id",
//          referencedColumnName = "teacherId"
//    )
//    private List<Course> courses; // in this field we have use the above 2 annotation

}

/* we commented the above code because rather than define this that the one course can be taught
by different teachers we can simply define a Many courses taught by single teacher this will
increase our readability for that we will use @ManyToOne in  Course Entity */

/*
  Here in this class now we will see @OneToMany, @ManyToOne
  1) One teacher can have List of courses inside a perticular teacher class
*/