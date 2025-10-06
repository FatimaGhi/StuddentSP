package com.universite.student.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record StudentCreat(
        @NotBlank(message = " first name is requires  ")
        @Size(max = 100, message = "first name cannot exceed 100 characters")
        String firstName,
        @NotNull(message = " last name is requires")
        @Size(max = 100, message = "Last name cannot exceed 100 characters")
        String lastName,
        int age,
        @NotNull(message = " Name_department is requires")
        @Size(max = 100, message = "Name_department cannot exceed 100 characters")
        String Name_department) {


}
