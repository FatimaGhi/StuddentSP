package com.universite.student.controller;

import com.universite.student.entities.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/Students")
public class StudentController {

//    @GetMapping("/getname")
//    public void  printStudentName()
//    {
//        System.out.print("hello hello hello fatima zahrae ");
//
//    }

    ArrayList<Student> students = new ArrayList<>(List.of(
            new Student("S001", "Fatima", "Zahrae", 24),
            new Student("S002", "Ahmed", "Ali", 22))


    );


    @GetMapping
    public ArrayList<Student> GetallStudents() {
        return students;
    }

    @GetMapping("/hello")
    public String Helloword() {
        return "fatima zahrae  done !! ";
    }

    @GetMapping("/{studentid}")
    public String findstudent(@PathVariable String studentid) {
        return studentid;
    }

    @GetMapping("/test")
    public String test() {
        return "i am good ";
    }

    @PostMapping
    public ResponseEntity<Student> setstudent(@RequestBody @Valid Student s) {
        students.add(s);
        return new ResponseEntity<Student>(s, HttpStatus.CREATED);
    }
}
