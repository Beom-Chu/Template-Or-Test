package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapTest {

    /* SortedMap 순서가 보장되는 Map */

    @Test
    public void testString() {
        SortedMap<String, String> sortedMap = new TreeMap<>();

        sortedMap.put("b","bbb");
        sortedMap.put("c","ccc");
        sortedMap.put("f","fff");
        sortedMap.put("a","aaa");
        sortedMap.put("e","eee");

        System.out.println("[[[sortedMap = " + sortedMap);
        System.out.println("[[[sortedMap.firstKey() = " + sortedMap.firstKey());
        System.out.println("[[[sortedMap.lastKey() = " + sortedMap.lastKey());
    }
    @Test
    public void testPath() {
        SortedMap<Path, String> sortedMap = new TreeMap<>();

        sortedMap.put(Path.of("b","c"),"bbb");
        sortedMap.put(Path.of("c","b"),"ccc");
        sortedMap.put(Path.of("a","a"),"fff");
        sortedMap.put(Path.of("a","b"),"aaa");
        sortedMap.put(Path.of("b","a"),"eee");

        System.out.println("[[[sortedMap = " + sortedMap);
        System.out.println("[[[sortedMap.firstKey() = " + sortedMap.firstKey());
        System.out.println("[[[sortedMap.lastKey() = " + sortedMap.lastKey());
    }
}
