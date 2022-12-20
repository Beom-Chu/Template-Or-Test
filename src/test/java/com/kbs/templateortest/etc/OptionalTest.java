package com.kbs.templateortest.etc;

import com.kbs.templateortest.lombok.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@Slf4j
public class OptionalTest {

    @Test
    public void testOptional() {
        Optional<String> test = Optional.of("test");

        System.out.println("[[[test = " + test);

        User user = new User();
        user.setId(123);
        user.setName("이름");
        Optional<User> optUser = Optional.of(user);
        System.out.println("[[[optUser = " + optUser);

        Optional<String> optNull = Optional.ofNullable(null);
        System.out.println("[[[optNull = " + optNull);

        log.info("test : {}, optUser : {}, optNull : {}" , test, optUser, optNull);


    }

}
