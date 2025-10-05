package com.universite.student.Interfaces;

import com.universite.student.Dtos.StudentCreat;
import com.universite.student.Dtos.StudentUpDate;
import com.universite.student.entities.Student;

import java.util.List;

public interface StudenService {

    public String testDI();

    public Student CreatStudent(StudentCreat studentCreat);

    public List<Student> FindAllStudent();

    public void DeleteStudent(long id);

    public Student UpDateStudent(long idStudent, StudentUpDate studentUpDate);

    public Student findOneStudent(long idStudent);
}
