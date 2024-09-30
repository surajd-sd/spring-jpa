package com.JPA.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

// we will do relation here @OneToOne,@OneToMany etc...
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")

public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course-material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"

    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false // this means you have to compulsory give the Course when you
                             // save the CourseMaterial, therefore in your CourseMaterialRepositoryTest
                             // you have to save a course also
    )
    @JoinColumn(   // this means that this field is referencing to which column of Course Class
            name = "course_id",
            referencedColumnName = "courseId" // field in Course Class

    )
    private Course course;

    /* This @ToString(exclude = "course") tells that the course field should not be included in the
       generated toString() method for the class
    */

}

/*
fetch = FetchType.LAZY this is a proper we use when we want to fetch the data of course material at
same time if we want to fetch the data of the Course class then we use this property based on our
requirement we use fetch type, if dont want to fetch the data of other class then we use the fetch type
as fetch = FetchType.LAZY, if we want to fetch then the fetch type will be fetch = FetchType.EAGER
*/
