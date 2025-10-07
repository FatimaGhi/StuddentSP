package com.universite.student.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DeprtCreat(@NotBlank(message = " Department_Name name is requires  ")
                         @Size(max = 100, message = "Department_Name cannot exceed 100 characters")
                         String Department_Name) {
}

