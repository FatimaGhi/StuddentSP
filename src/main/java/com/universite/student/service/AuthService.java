package com.universite.student.service;

import com.universite.student.Dtos.SignupRequest;
import com.universite.student.entities.UserAccount;
import com.universite.student.repositories.UserAccountRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserAccountRepo userAccountRepo;
    private StudentServiceImp studentServiceImp;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserAccountRepo userAccountRepo, StudentServiceImp studentServiceImp, PasswordEncoder passwordEncoder) {
        this.userAccountRepo = userAccountRepo;
        this.studentServiceImp = studentServiceImp;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(SignupRequest signupRequest) {
        UserAccount userAccount = UserAccount
                .builder()
                .userName(signupRequest.username())
                .password(passwordEncoder.encode(signupRequest.password()))
                .student(studentServiceImp.findOneStudent(signupRequest.studentID()))
                .role("user")
                .build();

        userAccountRepo.save(userAccount);

    }


}
