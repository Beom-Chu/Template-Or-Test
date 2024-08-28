package com.kbs.templateortest.stream;

import lombok.*;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
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

    @DisplayName("Collectors.joining 사용")
    @Test
    public void testJoining() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        String joining = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "(", ")"));

        System.out.println("[[[joining = " + joining);


        List<Integer> EmptyNumbers = new ArrayList<>();

        String EmptyJoining = EmptyNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "(", ")"));

        System.out.println("[[[빈값 joining = " + EmptyJoining);
    }

    @DisplayName("sorted 사용 - 조건 여러개 thenComparing")
    @Test
    public void testSorted() {
        List<User> users = new ArrayList<>();
        users.add(new User(1,"kbs"));
        users.add(new User(3,"ksy"));
        users.add(new User(6,"ljs"));
        users.add(new User(2,"ljs"));
        users.add(new User(5,"ljs"));
        users.add(new User(4,"kdy"));

        List<User> sorted1 = users.stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());

        System.out.println("sorted1 => id 정렬");
        for(User user : sorted1) {
            System.out.println(user);
        }
        System.out.println();

        List<User> sorted2 = users.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());

        System.out.println("sorted2 = name 정렬");
        for(User user : sorted2) {
            System.out.println(user);
        }
        System.out.println();

        List<User> sorted3 = users.stream()
                .sorted(Comparator.comparing(User::getName)
                        .thenComparing(User::getId))
                .collect(Collectors.toList());

        System.out.println("sorted2 = name, id 정렬");
        for(User user : sorted3) {
            System.out.println(user);
        }
        System.out.println();

        List<User> sorted4 = users.stream()
                .sorted(Comparator.comparing(User::getName)
                        .thenComparing(User::getId).reversed())
                .collect(Collectors.toList());

        System.out.println("sorted2 = name, 역순 id 정렬");
        for(User user : sorted4) {
            System.out.println(user);
        }
        System.out.println();

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

    @Test
    @DisplayName("list에서 list를 필터링")
    public void testFilterListFromList() {
        List<Integer> targets = List.of(111, 222, 333, 444, 555, 666);
        List<Integer> deletedIds = List.of(222, 666);

        List<Integer> filterIds = targets.stream()
                .filter(o -> !deletedIds.contains(o))
                .collect(Collectors.toList());

        System.out.println("[[[filterIds = " + filterIds);
    }

    @Test
    @DisplayName("Stream으로 Map 반환 테스트")
    public void testToMap() {
        List<User> users = new ArrayList<>();
        users.add(new User(2,"ljs"));
        users.add(new User(1,"kbs"));
        users.add(new User(3,"ksy"));

        Map<Integer, String> map = users.stream()
                .collect(Collectors.toMap(User::getId, User::getName));

        System.out.println("[[[map = " + map);

        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    @Test
    @DisplayName("Stream으로 TreeMap 반환 테스트")
    public void testToTreeMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("c", "ccc");
        map.put("d", "ddd");
        map.put("b", "bbb");

        TreeMap<String, String> treeMap = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1,o2)->o1, TreeMap::new));

        treeMap.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    @Test
    @DisplayName("Stream으로 grouping, distinct 테스트")
    public void testGroupingByDistinct() {
        List<String> list = Arrays.asList("111", "222", "222", "333", "444", "111", "555");

        Map<String, List<String>> collect = list.stream()
                .collect(Collectors.groupingBy(String::new));
        System.out.println("[[[collect = " + collect);

        List<String> collect2 = new ArrayList<>(collect.keySet());
        System.out.println("[[[collect2 = " + collect2);


        List<String> collect3 = list.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("[[[collect3 = " + collect3);


        List<User> users = Arrays.asList(new User(1, "aa"), new User(1, "aa"), new User(2, "bb"), new User(3, "cc"), new User(3, "cc"));
        List<User> collect4 = users.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("[[[collect4 = " + collect4);
    }

    @Test
    @DisplayName("stream으로 flatMap 테스트")
    void testFlatMap() {

        List<String> list = List.of("abc", "def");
        System.out.println(list);

        // 리스트에 담긴 문자열을 하나의 문자로 분리해서 리스트에 담기

        // flatMap을 사용하지 않으면 2차원 배열로 담김
        List<List<String>> list2 = list.stream()
                .map(o -> Arrays.stream(o.split("")).collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(list2);

        // flatMap을 사용하면 평탄화가 되어 1차원 배열로 변환
        List<String> list3 = list.stream()
                .map(o -> Arrays.stream(o.split("")).collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(list3);

    }
}
