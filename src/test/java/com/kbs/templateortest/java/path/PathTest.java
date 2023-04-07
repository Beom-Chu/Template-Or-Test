package com.kbs.templateortest.java.path;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

public class PathTest {

    @Test
    void test() {
        Path path = Path.of("AA", "BB", "CCC");
        Path toAbsolutePath = path.toAbsolutePath();
        String s = toAbsolutePath.toString();

        System.out.println("[[[path = " + path);
        System.out.println("[[[toAbsolutePath = " + toAbsolutePath);
        System.out.println("[[[s = " + s);

        String str = "\"Number of Records\",\"1234\"";

        System.out.println("[[[str.contains(\"Number of Records\") = " + str.contains("Number of Records"));
    }
}
