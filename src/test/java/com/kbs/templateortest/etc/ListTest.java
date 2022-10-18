package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

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
}
