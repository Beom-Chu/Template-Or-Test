package com.kbs.templateortest.valid.controller;

import com.kbs.templateortest.valid.service.UserService;
import com.kbs.templateortest.valid.vo.AddUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /*
     * @Valid는 Controller에서만 동작
     * 유효성 검증 실패시 MethodArgumentNotValidException 발생
     */
    @PostMapping("/user")
    public ResponseEntity<AddUserRequest> addUser(@RequestBody @Valid AddUserRequest addUserRequest) {

        System.out.println("UserController.addUser");

        System.out.println("[[[addUserRequest = " + addUserRequest);

        return ResponseEntity.ok(addUserRequest);
    }

    /*
     * @Validated는 메소드의 요청을 가로채서 유효성을 검증할 때 사용. userService에서 사용.
     * 유효성 검증 실패시 ConstraintViolationException 발생
     */
    @PostMapping("/user2")
    public ResponseEntity<AddUserRequest> addUser2(@RequestBody AddUserRequest addUserRequest) {

        System.out.println("UserController.addUser2");

        AddUserRequest result = userService.addUser(addUserRequest);

        return ResponseEntity.ok(result);
    }
}
