package com.universite.student.Interfaces;

import com.universite.student.Dtos.DeprtCreat;
import com.universite.student.entities.Department;

import java.util.List;

public interface DepartService {

    public Department CreatDepart(DeprtCreat departCreat);

    public List<Department> GetAllDepart();

    public Department GetOneDeaprt(Long idDepart);

    public void DeleteDepart(long id);
}
