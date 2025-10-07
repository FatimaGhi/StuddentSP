package com.universite.student.Interfaces;

import com.universite.student.Dtos.SubjectCreat;
import com.universite.student.entities.Subject;

import java.util.List;

public interface SubjectService {


    public Subject CreatSubject(SubjectCreat subjectCreat);

    public List<Subject> GetAllSubject();

    public Subject GetOneSubject(Long idDSubject);

    public void DeleteSubject(long id);
}
