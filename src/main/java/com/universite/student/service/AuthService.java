package com.universite.student.service;

import com.universite.student.Dtos.LoginRequest;
import com.universite.student.Dtos.SignupRequest;
import com.universite.student.config.JWThelper;
import com.universite.student.entities.UserAccount;
import com.universite.student.repositories.UserAccountRepo;
import com.universite.student.shared.CustomResponseException;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserAccountRepo userAccountRepo;
    private StudentServiceImp studentServiceImp;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JWThelper jwThelper;

    public AuthService(UserAccountRepo userAccountRepo, StudentServiceImp studentServiceImp, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, @Lazy JWThelper jwThelper) {
        this.userAccountRepo = userAccountRepo;
        this.studentServiceImp = studentServiceImp;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwThelper = jwThelper;
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

    public String login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                ));


        UserAccount user = userAccountRepo.findByUserName(loginRequest.username()).orElseThrow(() -> CustomResponseException.BadCredentials());
        System.out.println("###########################" + user);
        return jwThelper.generateToken(user);

//        return "login done !!";

    }


}
