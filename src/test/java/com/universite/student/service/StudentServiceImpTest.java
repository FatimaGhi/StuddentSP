package com.universite.student.service;

import com.universite.student.repositories.DepartRepo;
import com.universite.student.repositories.StudentRepo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentServiceImpTest {

    @Mock
    private StudentRepo studentRepo;
    @Mock
    private DepartRepo departRepo;
    @InjectMocks
    private StudentServiceImp studentServiceImp;

//    @Test
//    void TestCreatStudent() {
////        arrange
//        StudentCreat studentCreat = new StudentCreat("fatimazahrae", "zak", 24, "informatique");
//        Department department = Department.builder().id_D(1L).name("informatique").build();
//        Mockito.when(departRepo.findByName("informatique")).thenReturn(Optional.of(department));
//        Mockito.when(studentRepo.save(Mockito.any(Student.class))).thenAnswer(invocation -> invocation.getArgument(0));
////        act
//        Student student = studentServiceImp.CreatStudent(studentCreat);
////        assert
//        Assertions.assertNotNull(student);
//        Assertions.assertEquals(student.getFirstName(), studentCreat.firstName());
//        Assertions.assertEquals(22, student.getAge());
//
//
//    }
}