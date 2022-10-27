package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

public class ListTest {

    @Test
    public void test() {

        List<String> list = new LinkedList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        System.out.println("[[[list = " + list);

        list.clear();

        System.out.println("[[[list = " + list);

    }

    @Test
    public void test2() {
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        List<String> list = new ArrayList<>(set);

        System.out.println("[[[list = " + list);
    }

    @Test
    public void speedTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 700; i++) {
            list.add(i);
        }

        long st = System.currentTimeMillis();
        for(Integer i : list) {
            System.out.println(LocalDateTime.now() + "[[[i = " + i);
        }

        System.out.println("[[[ time : " + (System.currentTimeMillis() - st));

    }
}
