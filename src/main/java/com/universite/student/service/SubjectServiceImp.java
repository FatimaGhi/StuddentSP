package com.universite.student.service;

import com.universite.student.Dtos.SubjectCreat;
import com.universite.student.Interfaces.SubjectService;
import com.universite.student.entities.Subject;
import com.universite.student.repositories.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImp implements SubjectService {

    SubjectRepo subjectRepo;

    SubjectServiceImp(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    public Subject CreatSubject(SubjectCreat subjectCreat) {
        Subject subject = new Subject();
        subject.setNameSubject(subjectCreat.Subject_Name());
        subjectRepo.save(subject);
        return subject;
    }

    public List<Subject> GetAllSubject() {
        List<Subject> subjects = subjectRepo.findAll();
        return subjects;
    }

    public Subject GetOneSubject(Long idDSubject) {
        return null;
    }

    public void DeleteSubject(long id) {

    }
}
