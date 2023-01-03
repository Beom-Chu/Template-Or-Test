package com.kbs.templateortest.valid.service;

import com.kbs.templateortest.valid.vo.AddUserRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
public class UserService {

    /**
     * 메소드의 요청을 가로채서 유효성을 검증할 때는 @Validated 사용.
     */
    public AddUserRequest addUser(@Valid AddUserRequest addUserRequest) {

        System.out.println("UserService.addUser");
        System.out.println("[[[addUserRequest = " + addUserRequest);

        return addUserRequest;
    }
}
