package com.kbs.templateortest.etc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ListTest {

    @Test
    public void test() {

        List<String> list = new LinkedList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        System.out.println("[[[list = " + list);

        list.remove("bbb");
        System.out.println("[[[list = " + list);

        list.remove(1);
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

        List<String> notAaa = set.stream()
                .filter(o -> !o.equals("aaa"))
                .collect(Collectors.toList());

        System.out.println("[[[notAaa = " + notAaa);
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

    @Test
    public void ofTest() {
        List<String> list = null;

        System.out.println("[[[list = " + (list == null));

        list = List.of();

        System.out.println("[[[list = " + list);
    }
    @Test
    public void testInputListNull() {
        List<String> list = new ArrayList<>();

        list.add(null);

        System.out.println("[[[list = " + list);
    }

    @Test
    @DisplayName("다른 타입의 객체를 List.contains로 비교")
    public void testNotSameTypeContains() {
        List<String> strings = Arrays.asList("a", "b", "c", null);
        Long l = 10L;
        Long l2 = null;

        /* 다른 타입으로 비교시 에러 없이 false 반환 */
        System.out.println("[[[strings.contains(l) = " + strings.contains(l));

        /* 다른 타입이라도 null은 비교되어 true 반환 */
        System.out.println("[[[strings.contains(l2) = " + strings.contains(l2));


        /* AbstractCollection.contains에 null 비교 로직 존재
        public boolean contains(Object o) {
            Iterator<E> it = iterator();
            if (o==null) {
                while (it.hasNext())
                    if (it.next()==null)
                        return true;
            } else {
                while (it.hasNext())
                    if (o.equals(it.next()))
                        return true;
            }
            return false;
        }
        */
    }
}
