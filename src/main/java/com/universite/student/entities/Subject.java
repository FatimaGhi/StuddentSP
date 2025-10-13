package com.universite.student.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_S;
    @Column(name = "Name Subject  ", nullable = false, length = 100, unique = true)
    private String NameSubject;

}
