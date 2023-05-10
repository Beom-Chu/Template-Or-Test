package com.kbs.templateortest.time;

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

    @Test
    public void test2() {
        LocalDate date = LocalDate.of(0, 1, 1);
        System.out.println("[[[date = " + date);

        LocalDate parse = LocalDate.parse("20230101",DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println("[[[parse = " + parse);
    }

    @Test
    public void testStringToDateToString() {

        String[] executeDates = {"20230510", "2023-05-10", "2023","", null};

        for (String executeDate : executeDates) {

            try {
                String replaceExecuteDate = executeDate.replaceAll("[^0-9]+", "");

                LocalDate localDate = LocalDate.parse(replaceExecuteDate, DateTimeFormatter.BASIC_ISO_DATE);

                String isoLocalDate = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
                String basicIsoDate = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);

                System.out.println("[[[[[executeDate = " + executeDate);
                System.out.println("[[[isoLocalDate = " + isoLocalDate);
                System.out.println("[[[basicIsoDate = " + basicIsoDate);

            } catch (Exception e) {
                System.out.println("[[[executeDate = " + executeDate);
                System.out.println(e);
            } finally {
                System.out.println();
            }

        }

    }
}
