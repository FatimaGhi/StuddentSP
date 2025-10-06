package com.universite.student.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_D;
    @Column(name = "Name departement ", nullable = false, length = 100, unique = true)
    private String name;
}
