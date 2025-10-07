package com.universite.student.controller;

import com.universite.student.Dtos.SubjectCreat;
import com.universite.student.Interfaces.SubjectService;
import com.universite.student.entities.Subject;
import com.universite.student.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Subjects")
public class SubjectController {

    SubjectService subjectService;

    SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Subject>> SubjectCreat(@RequestBody @Valid SubjectCreat subjectCreat) {
        Subject Subjects = subjectService.CreatSubject(subjectCreat);
        return new ResponseEntity<GlobalResponse<Subject>>(new GlobalResponse<Subject>(Subjects), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Subject>>> findAllDepart() {
        return new ResponseEntity<GlobalResponse<List<Subject>>>(new GlobalResponse<List<Subject>>(subjectService.GetAllSubject()), HttpStatus.OK);
    }
}
