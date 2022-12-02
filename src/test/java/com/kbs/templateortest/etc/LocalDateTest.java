package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;

import java.sql.Date;
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

    @Test
   public void testConvertLocalDateToDate() {
        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);
        LocalDate reLocalDate = date.toLocalDate();

        System.out.println("[[[localDate = " + localDate);
        System.out.println("[[[date = " + date);
        System.out.println("[[[reLocalDate = " + reLocalDate);
    }
}
