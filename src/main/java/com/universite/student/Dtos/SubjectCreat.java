package com.universite.student.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SubjectCreat(@NotBlank(message = " Subject_Name name is requires  ")
                           @Size(max = 100, message = "Subject_Name cannot exceed 100 characters")
                           String Subject_Name) {
}
