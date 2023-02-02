package com.kbs.templateortest.argument.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/arg-resolver")
public class UserArgController {

    /*
    Test
    curl --location --request POST 'http://localhost:8080/arg-resolver/user?id=2000'
     */
    @PostMapping("/user")
    public ResponseEntity<Void> createUser(UserDto userDto) {

        log.info(userDto.toString());

        return ResponseEntity.ok().build();
    }

    /*
    Test
    curl --location --request POST 'http://localhost:8080/arg-resolver/group?id=2000&name=mn'
     */
    @PostMapping("/group")
    public ResponseEntity<Void> createGroup(GroupDto groupDto) {

        log.info(groupDto.toString());

        return ResponseEntity.ok().build();
    }
}
