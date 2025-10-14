package com.universite.student.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// unique id (not null)
    @Column(name = "first_Name", nullable = false, length = 100)
    private String firstName;
    @Column(name = "last_Name", nullable = false, length = 100)
    private String lastName;
    @Column(name = "age", nullable = false)
    private int age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;


    @ManyToMany
    @JoinTable(name = "Student_subject", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id_S"))
    private Set<Subject> subjects = new HashSet<>();
}
