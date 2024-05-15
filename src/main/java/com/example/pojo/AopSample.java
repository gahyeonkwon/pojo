package com.example.pojo;

import com.example.pojo.LocalExcutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AopSample {

    @LocalExcutionTime
    @GetMapping("/test1")
    public String test1 () {

        log.info("비즈니스로직이 호출됩니다.");

        return "test1";
    }

    @TestAOP
    @GetMapping("/test2")
    public void test2 ()  {
        throw new NullPointerException("hello world!");
    }
}
