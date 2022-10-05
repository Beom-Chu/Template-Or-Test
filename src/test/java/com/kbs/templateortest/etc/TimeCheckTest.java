package com.kbs.templateortest.etc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TimeCheckTest {

    String[] name = new String[]{"kim", "lee", "park", "choi", "bea", "byun", "jin", "kang", "her", "hong"};

    @Test
    public void test(){

        long start = System.currentTimeMillis();

        ArrayList<UserDto> userDtos = new ArrayList<>();
        for (long i = 0; i < 100000; i++) {
            int r = (int) (Math.random() * 10);
            userDtos.add(new UserDto(i, (long) r + 20, "고객"));
        }

        Map<Long, String> names = new HashMap<>();
        for (long i = 0; i < 100000; i++) {
            int r = (int) (Math.random() * 10);
            names.put(i, name[r]);
        }

        for(UserDto userDto : userDtos) {
            userDto.setName(names.getOrDefault(userDto.getId(), "고객"));
        }

        System.out.println( "time : " + (System.currentTimeMillis() - start));

//        for(UserDto userDto : userDtos) {
//            System.out.println("[[[userDto = " + userDto);
//        }
    }

    @Data
    @AllArgsConstructor
    public static class UserDto {
        private Long id;
        private Long age;
        private String name;
    }
}
