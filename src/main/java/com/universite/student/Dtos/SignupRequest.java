package com.universite.student.Dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record SignupRequest(
        @NotNull(message = "username is required")
        @Size(min = 2, max = 50, message = "min c 2 and max is 50 c ")
        String username,

        @NotNull(message = "password is required")
        @Size(min = 2, max = 50, message = "min c 2 and max is 50 c ")
        String password,

        @NotNull(message = " student ID is required")
        Long studentID
) {
}

