package com.universite.student.service;

import com.universite.student.Dtos.StudentCreat;
import com.universite.student.Dtos.StudentUpDate;
import com.universite.student.Interfaces.StudenService;
import com.universite.student.entities.Department;
import com.universite.student.entities.Student;
import com.universite.student.repositories.DepartRepo;
import com.universite.student.repositories.StudentRepo;
import com.universite.student.shared.CustomResponseException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class StudentServiceImp implements StudenService {
    DepartRepo departRepo;
    @Autowired
    private StudentRepo studentRepo;

    StudentServiceImp(DepartRepo departRepo) {
        this.departRepo = departRepo;
    }

    public Student CreatStudent(StudentCreat studentCreat) {
        Student student = new Student();
        student.setFirstName(studentCreat.firstName());
        student.setLastName(studentCreat.lastName());
        student.setAge(studentCreat.age());
        Department dept = departRepo.findByName(studentCreat.Name_department())
                .orElseThrow(() -> CustomResponseException.ResourceNotFound(" Despartment not found in data base "));
        student.setDepartment(dept);
        studentRepo.save(student);
        log.info(" ADD student  in data base");
        return student;
    }

    public List<Student> FindAllStudent() {

        return studentRepo.findAll();
    }

    public void DeleteStudent(long id) {

        if (!studentRepo.existsById(id))
            throw CustomResponseException.ResourceNotFound(" ***  Student with id " + id + "not found");

        studentRepo.deleteById(id);
    }

    public Student findOneStudent(long idStudent) {
        Student student = studentRepo.findById(idStudent).orElseThrow(() -> CustomResponseException.ResourceNotFound("id Resource is not found"));
        return student;
    }


    public Student UpDateStudent(long idStudent, StudentUpDate studentUpDate) {
        Student student = findOneStudent(idStudent);

        student.setLastName(studentUpDate.lastName());
        student.setFirstName(studentUpDate.firstName());
        studentRepo.save(student);
        return student;

    }

    public String testDI() {
        System.out.println("********************   dependency injection is done ");
        return " ********************   dependency injection is done ";
    }
}


