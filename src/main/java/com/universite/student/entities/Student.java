package com.universite.student.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {

    private String id;// unique id (not null)
    @NotBlank(message = " first name is requires")
    private String firstName;
    @NotNull(message = " last name is requires")
    @Email(message = "HADA MAXI EMAIL WAX KAD7KO 3LA NAS ")
    private String lastName;
    private int age;
}
