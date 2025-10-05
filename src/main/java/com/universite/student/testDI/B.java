package com.universite.student.testDI;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class B implements Test {
    public String TestDI() {
        return "***************** class B";
    }

}

