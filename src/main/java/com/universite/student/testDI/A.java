package com.universite.student.testDI;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("A")
public class A implements Test {
    public String TestDI() {
        return "***************** class A";
    }
}
