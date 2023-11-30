package com.esd.project.faculty.faculty_modification.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private int course_id;

    @Column(name = "course_code", nullable = false, length = 10)
    private String course_code;
    @Column(name="course_name", nullable = false, length = 50)
    private String course_name;

    @Column(name = "course_description", length = 100)
    private String course_description;

    @Column(name = "course_year",nullable = false, length = 100)
    private String course_year;

    @Column(name = "course_term",nullable = false, length = 100)
    private String course_term;

    @Column(name = "course_credits",nullable = false, length = 100)
    private Float course_credits;

    @Column(name = "course_capacity",nullable = false, length = 100)
    private int course_capacity;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id", unique = true)
    private Employee employee;

}







