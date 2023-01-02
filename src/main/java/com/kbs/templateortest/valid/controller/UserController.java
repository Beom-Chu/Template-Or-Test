package com.kbs.templateortest.valid.controller;

import com.kbs.templateortest.valid.vo.AddUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<AddUserRequest> addUser(@RequestBody @Valid AddUserRequest addUserRequest) {

        System.out.println("UserController.addUser");

        System.out.println("[[[addUserRequest = " + addUserRequest);

        return ResponseEntity.ok(addUserRequest);
    }
}
