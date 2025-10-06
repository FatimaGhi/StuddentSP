package com.universite.student.controller;

import com.universite.student.Dtos.DeprtCreat;
import com.universite.student.Interfaces.DepartService;
import com.universite.student.entities.Department;
import com.universite.student.entities.Student;
import com.universite.student.shared.GlobalResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartController {

    DepartService departService;

    DepartController(DepartService departService) {
        this.departService = departService;
    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Department>> DepartCreat(@RequestBody @Valid DeprtCreat deprtCreat) {
        Department department = departService.CreatDepart(deprtCreat);
        return new ResponseEntity<GlobalResponse<Department>>(new GlobalResponse<Department>(department), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Department>>> findAllDepart() {
        return new ResponseEntity<GlobalResponse<List<Department>>>(new GlobalResponse<List<Department>>(departService.GetAllDepart()), HttpStatus.OK);
    }

    @GetMapping("/{idDepart}")
    public ResponseEntity<GlobalResponse<Department>> DepartCreat(@PathVariable Long idDepart) {
        Department department = departService.GetOneDeaprt(idDepart);
        return new ResponseEntity<GlobalResponse<Department>>(new GlobalResponse<Department>(department), HttpStatus.OK);
    }


    @DeleteMapping("/{Departid}")
    public ResponseEntity<String> deleteStudentById(@PathVariable long Departid) {
        departService.DeleteDepart(Departid);
        return new ResponseEntity("*** department   is delete ", HttpStatus.OK);
    }

    @GetMapping("/{namedepart}/students")
    public ResponseEntity<GlobalResponse<List<Student>>> GetAllStudentByName(@PathVariable String namedepart) {
        List<Student> students = departService.findAllStudentByName(namedepart);
        return new ResponseEntity<GlobalResponse<List<Student>>>(new GlobalResponse<List<Student>>(students), HttpStatus.OK);
    }

}
