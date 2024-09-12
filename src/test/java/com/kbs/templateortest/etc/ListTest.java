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
    void test3() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.stream()
                .map(o -> o * 2)
                .forEach(System.out::println);

        System.out.println();

        Optional<String> optional = Optional.ofNullable(null);
        String result = optional.orElseGet(() -> "No Data");
        System.out.println(result);

        System.out.println();

        list.stream()
                .sorted((i1, i2) -> i2.compareTo(i1))
                .forEach(System.out::println);
    }

    @Test
    public void speedTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 700; i++) {
            list.add(i);
        }

        long st = System.currentTimeMillis();
        for (Integer i : list) {
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

    @Test
    public void testSorting() {
        LinkedList<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("ccc");
        list.add("eee");
        list.add("bbb");
        list.add("ddd");
        System.out.println("[[[list = " + list);

        TreeSet<String> set = new TreeSet<>();
        set.add("aaa");
        set.add("ccc");
        set.add("eee");
        set.add("bbb");
        set.add("ddd");
        System.out.println("[[[set = " + set);

        PriorityQueue<Object> que = new PriorityQueue<>();
    }

    @Test
    public void testClone() {
        LinkedList<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("ccc");
        list.add("eee");
        list.add("bbb");
        list.add("ddd");

        LinkedList<String> clone = (LinkedList<String>) list.clone();
        clone.remove(0);
        clone.remove(0);
        clone.set(0, "123");

        System.out.println("[[[list = " + list);
        System.out.println("[[[clone = " + clone);

        LinkedList<String> newList = new LinkedList<>(list);
        newList.remove(0);
        newList.remove(0);

        System.out.println("[[[list = " + list);
        System.out.println("[[[newList = " + newList);
    }

    @Test
    void testListEquals() {
        List<String> list1 = List.of("a", "b", "c");
        List<String> list2 = new ArrayList<>(List.of("a", "c", "b"));
        List<String> list3 = List.of("a", "b", "c");

        System.out.println("list1.equals(list2) = " + list1.equals(list2));
        System.out.println("list1.equals(list3) = " + list1.equals(list3));

        list2.sort(Comparator.naturalOrder());
        System.out.println("정렬 후 => list1.equals(list2) = " + list1.equals(list2));
        // List의 순서가 일치해야 List equals가 같게 나옴
    }
}
