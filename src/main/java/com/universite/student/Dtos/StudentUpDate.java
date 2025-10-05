package com.universite.student.Dtos;

import jakarta.validation.constraints.NotNull;

public record StudentUpDate(@NotNull(message = " first name is requires DTO ")
                            String firstName,
                            @NotNull(message = " last name is requires")
//                            @Email(message = "HADA MAXI EMAIL WAX KAD7KO 3LA NAS ")
                            String lastName) {
}
