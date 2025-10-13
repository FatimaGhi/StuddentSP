package com.universite.student.shared;

import com.universite.student.Dtos.StudentVue;
import com.universite.student.entities.Student;

public class studentMapper {

    public static StudentVue toDto(Student student) {
        return new StudentVue(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getDepartment() != null ? student.getDepartment().getName() : null
        );
    }
}
