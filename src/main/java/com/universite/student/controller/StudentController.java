package com.universite.student.controller;

import com.universite.student.Dtos.StudentCreat;
import com.universite.student.Dtos.StudentUpDate;
import com.universite.student.Interfaces.StudenService;
import com.universite.student.entities.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Students")
public class StudentController {


    public StudenService studentservice;


    StudentController(StudenService studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping
    public List<Student> GetAllStudents() {


        return studentservice.FindAllStudent();
    }

    @PostMapping
    public ResponseEntity<Student> setstudent(@RequestBody @Valid StudentCreat studentcreat) {
        Student student;
        student = studentservice.CreatStudent(studentcreat);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    @DeleteMapping("/{studentid}")
    public ResponseEntity<String> deleteStudentById(@PathVariable long studentid) {
        studentservice.DeleteStudent(studentid);
        return new ResponseEntity("*** student  is delete ", HttpStatus.OK);
    }

    @PutMapping("/{studentid}")
    public ResponseEntity<Student> updateStudent(@PathVariable long studentid, @RequestBody @Valid StudentUpDate studentUpdate) {

        Student student = studentservice.UpDateStudent(studentid, studentUpdate);

        return new ResponseEntity<Student>(student, HttpStatus.OK);

    }

    @GetMapping("/{studentid}")
    public ResponseEntity<Student> getOneStudent(@PathVariable long studentid) {
        Student student = studentservice.findOneStudent(studentid);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

}
