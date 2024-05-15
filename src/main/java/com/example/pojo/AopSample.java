package com.example.pojo;

import com.example.pojo.LocalExcutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopSample {

    @LocalExcutionTime
    @GetMapping("/test1")
    public String test1 () {

        System.out.println("service code");

        return "test1";
    }

    @LocalExcutionTime
    @GetMapping("/test2")
    public String test2 () {
        System.out.println(" service code2");

        return "test2";
    }
}
