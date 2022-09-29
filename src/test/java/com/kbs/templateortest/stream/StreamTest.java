package com.kbs.templateortest.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    @DisplayName("IntStream을 활용한 Stream - index 사용")
    @Test
    public void testIntStream() {

        String[] array = { "a", "b", "c", "d", "e" };

        // 배열에서 index와 배열값 매칭해서 출력
        IntStream
                .range(0, array.length)
                .mapToObj(index -> String.format("%d -> %s", index, array[index]))
                .forEach(System.out::println);


        // 배열에서 첫번째 값을 제외한 값 구하기
        String[] filterArrays = IntStream.range(0, array.length)
                .filter(idx -> idx != 0)
                .mapToObj(idx -> array[idx])
                .toArray(String[]::new);

        System.out.println("[[[filterArrays = " + Arrays.toString(filterArrays));
        Assertions.assertEquals(4, filterArrays.length);


        // List에서 첫번째 값을 제외한 값 구하기
        List<User> users = new ArrayList<>();
        users.add(new User(10, "Kim"));
        users.add(new User(20, "Lee"));
        users.add(new User(30, "Park"));

        List<User> filterUsers = IntStream.range(0, users.size())
                .filter(i -> i > 0)
                .mapToObj(users::get)
                .collect(Collectors.toList());

        System.out.println("[[[filterUsers = " + filterUsers);
        Assertions.assertEquals(2, filterUsers.size());


    }

    @DisplayName("AtomicInteger를 활용한 Stream - index 사용")
    @Test
    public void testAtomicInteger() {

        // List에서 첫번째 값을 제외한 값 구하기
        List<User> users = new ArrayList<>();
        users.add(new User(10, "Kim"));
        users.add(new User(20, "Lee"));
        users.add(new User(30, "Park"));

        /*  AtomicInteger는 int 자료형을 갖고 있는 wrapping 클래스.
          멀티쓰레드 환경에서 동시성을 보장 */
        AtomicInteger idx = new AtomicInteger();
        List<User> filterUsers = users.stream()
                .filter(o -> idx.getAndIncrement() > 0)
                .collect(Collectors.toList());

        System.out.println("[[[filterUsers = " + filterUsers);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        Integer id;
        String name;
        String name2;

        public User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }


    @Test
    public void test1(){
        List<User> users = new ArrayList<>();
        users.add(new User(1,"kbs"));
        users.add(new User(2,"ljs"));

        List<String> names = users.stream().map(User::getName).collect(Collectors.toList());

        System.out.println("[[[names = " + names);

        List<User> users2 = new ArrayList<>();
        users2.add(new User(3,null));
        users2.add(new User(4,null));

        List<String> names2 = users2.stream().map(User::getName).collect(Collectors.toList());

        System.out.println("[[[names2 = " + names2);


        List<User> users3 = new ArrayList<>();
        users3.add(new User(5, null, "kim"));
        users3.add(new User(6, null, "lee"));
        users3.add(new User(7, "jb", "bae"));
        users3.add(new User(8, "", "you"));

        List<String> names3 = users3.stream().map(o-> ObjectUtils.isEmpty(o.getName()) ? o.getName2() : o.getName()).collect(Collectors.toList());

        System.out.println("[[[names3 = " + names3);
    }
}
