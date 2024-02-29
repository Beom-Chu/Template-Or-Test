package com.kbs.templateortest.etc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BufferedWriterTest {

    @Test
    @DisplayName("println과 BufferedWriter 성능 비교")
    public void test() throws IOException {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            strings.add(String.valueOf(UUID.randomUUID()));
        }

        long printlnStart = System.currentTimeMillis();
        printSystemOutPrintln(strings);
        long printlnTime = System.currentTimeMillis() - printlnStart;

        long writerStart = System.currentTimeMillis();
        printBufferedWriter(strings);
        long writerTime = System.currentTimeMillis() - writerStart;

        // println보다 BufferedWriter가 2배 이상 빠름.

        System.out.println("[[[printlnTime = " + printlnTime);
        System.out.println("[[[writerTime = " + writerTime);
    }

    private void printBufferedWriter(List<String> strings) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : strings) {
            writer.write(s + " \n");
        }
        writer.flush();
        writer.close();
    }

    private void printSystemOutPrintln(List<String> strings) {
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
