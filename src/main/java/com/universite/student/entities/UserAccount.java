package com.universite.student.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class UserAccount {
    @Id
    @Column(name = "idUser", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Username", nullable = false, length = 100, unique = true)
    private String userName;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "role", nullable = false, length = 100)
    private String role = "user";

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idStudent ", nullable = false, unique = true)
    private Student student;

}
