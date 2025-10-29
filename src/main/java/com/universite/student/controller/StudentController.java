package com.universite.student.controller;

import com.universite.student.Dtos.StudentCreat;
import com.universite.student.Dtos.StudentUpDate;
import com.universite.student.Dtos.StudentVue;
import com.universite.student.Interfaces.StudenService;
import com.universite.student.entities.Student;
import com.universite.student.shared.GlobalResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "Gestion app students  ",
                description = " CRUD students , CRUD  Department ",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8080/"
        )
)
@RestController
@RequestMapping("Students")
public class StudentController {
    public StudenService studentservice;

    StudentController(StudenService studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping
    public ResponseEntity<GlobalResponse<List<StudentVue>>> GetAllStudents() {
        List<Student> students = studentservice.FindAllStudent();

        List<StudentVue> studentVues = students.stream()
                .map(student -> new StudentVue(
                        student.getId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getAge(),
                        student.getDepartment() != null ? student.getDepartment().getName() : null
                ))
                .toList();

        return new ResponseEntity<>(new GlobalResponse<List<StudentVue>>(studentVues), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<GlobalResponse<StudentVue>> setstudent(@RequestBody @Valid StudentCreat studentcreat) {
        Student student;
        student = studentservice.CreatStudent(studentcreat);
        StudentVue studentVue = new StudentVue(student.getId(), student.getFirstName(), student.getLastName(), student.getAge(), student.getDepartment() != null ? student.getDepartment().getName() : null);
        return new ResponseEntity<GlobalResponse<StudentVue>>(new GlobalResponse<StudentVue>(studentVue), HttpStatus.CREATED);
    }

    @DeleteMapping("/{studentid}")
    public ResponseEntity<String> deleteStudentById(@PathVariable long studentid) {
        studentservice.DeleteStudent(studentid);
        return new ResponseEntity("*** student  is delete ", HttpStatus.OK);
    }

    @PutMapping("/{studentid}")
    public ResponseEntity<GlobalResponse<StudentVue>> updateStudent(@PathVariable long studentid, @RequestBody @Valid StudentUpDate studentUpdate) {

        Student student = studentservice.UpDateStudent(studentid, studentUpdate);
        StudentVue studentVue = new StudentVue(student.getId(), student.getFirstName(), student.getLastName(), student.getAge(), student.getDepartment() != null ? student.getDepartment().getName() : null);
        return new ResponseEntity<GlobalResponse<StudentVue>>(new GlobalResponse<StudentVue>(studentVue), HttpStatus.OK);

    }

    @Operation(
            summary = " récupérer compte par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien récuperer",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = StudentVue.class)
                            )
                    ),
                    @ApiResponse(responseCode = "4xx", description = "erreur client"),
                    @ApiResponse(responseCode = "5xx", description = "erreur serveur"),
            }
    )
    @GetMapping("/{studentid}")
    public ResponseEntity<GlobalResponse<StudentVue>> getOneStudent(@PathVariable long studentid) {
        Student student = studentservice.findOneStudent(studentid);
        StudentVue studentVue = new StudentVue(student.getId(), student.getFirstName(), student.getLastName(), student.getAge(), student.getDepartment() != null ? student.getDepartment().getName() : null);
        return new ResponseEntity<GlobalResponse<StudentVue>>(new GlobalResponse<StudentVue>(studentVue), HttpStatus.OK);
    }


}
