package com.universite.student.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

}
