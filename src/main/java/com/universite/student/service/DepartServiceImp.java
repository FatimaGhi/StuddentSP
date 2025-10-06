package com.universite.student.service;

import com.universite.student.Dtos.DeprtCreat;
import com.universite.student.Interfaces.DepartService;
import com.universite.student.entities.Department;
import com.universite.student.entities.Student;
import com.universite.student.repositories.DepartRepo;
import com.universite.student.shared.CustomResponseException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImp implements DepartService {
    DepartRepo departRepo;

    DepartServiceImp(DepartRepo departRepo) {
        this.departRepo = departRepo;
    }

    @Override
    public Department CreatDepart(DeprtCreat departCreat) {
        Department department = new Department();
        department.setName(departCreat.Department_Name());
        departRepo.save(department);
        return department;
    }


    @Override
    public List<Department> GetAllDepart() {
        List<Department> department = departRepo.findAll();
        return department;
    }

    @Override
    public Department GetOneDeaprt(Long idDepart) {
        Department department = departRepo.findById(idDepart).orElse(null);
        return department;
    }


    public void DeleteDepart(long id) {

        if (!departRepo.existsById(id))
            throw CustomResponseException.ResourceNotFound(" ***  Department  with id " + id + "not found");

        departRepo.deleteById(id);
    }

    public List<Student> findAllStudentByName(String NameDepart) {

        Department department = departRepo.findByName(NameDepart)
                .orElseThrow(() -> new RuntimeException("Department not found: " + NameDepart));

        return department.getStudents();

    }
}

