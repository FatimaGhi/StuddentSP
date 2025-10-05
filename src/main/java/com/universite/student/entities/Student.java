package com.universite.student.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
