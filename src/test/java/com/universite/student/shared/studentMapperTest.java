package com.universite.student.shared;

import com.universite.student.Dtos.StudentVue;
import com.universite.student.entities.Department;
import com.universite.student.entities.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class studentMapperTest {

    private studentMapper sMapper;

    @BeforeEach
    void SetUp() {
        sMapper = new studentMapper();
    }

    @Test
    public void TestToDto() {
        // arrange
        Student student = Student.builder().id(124L).firstName("fatima").lastName("el ghiouan").age(2).department(Department.builder().id_D(1L).name("informatique").build()).build();
        //act
        StudentVue studentDto = sMapper.toDto(student);
        //assert
        Assertions.assertEquals(student.getFirstName(), studentDto.firstName());

    }

}