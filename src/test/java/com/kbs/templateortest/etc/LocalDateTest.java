package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {

    @Test
    public void test(){
        LocalDate now = LocalDate.now();

        System.out.println("[[[now = " + now);
        String s = now.toString().replaceAll("-", "");
        System.out.println("[[[now = " + s);

        String yyyyMMdd = now.format(DateTimeFormatter.ofPattern("yyyyMMdd170000"));
        System.out.println("[[[yyyyMMdd = " + yyyyMMdd);
    }
}
