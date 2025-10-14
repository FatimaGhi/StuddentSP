package com.universite.student.controller;


import com.universite.student.Dtos.SignupRequest;
import com.universite.student.service.AuthService;
import com.universite.student.shared.GlobalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<GlobalResponse<String>> signup(@RequestBody SignupRequest signupRequest) {
//        log.info(signupRequest.studentID());
        authService.signup(signupRequest);
        return new ResponseEntity<GlobalResponse<String>>(new GlobalResponse<>("signed Up"), HttpStatus.CREATED);
    }
}
