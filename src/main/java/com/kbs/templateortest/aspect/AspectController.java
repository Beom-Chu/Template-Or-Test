package com.kbs.templateortest.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aspect")
@Slf4j
public class AspectController {

    @GetMapping("/test")
    public String getTest() {
        log.info("[[[[aspect getTest ");
        return "aspect getTest!!!";
    }

    @PostMapping("/test")
    public String postTest() {
        log.info("[[[[aspect postTest ");
        return "aspect postTest!!!";
    }
}
