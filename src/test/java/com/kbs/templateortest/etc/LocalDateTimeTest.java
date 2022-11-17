package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;


public class LocalDateTimeTest {

    @Test
    public void testJodaToJava() {

        org.joda.time.LocalDateTime source = org.joda.time.LocalDateTime.now();
        java.time.LocalDateTime result = java.time.LocalDateTime.of(source.getYear(), source.getMonthOfYear(), source.getDayOfMonth(), source.getHourOfDay(), source.getMinuteOfHour(), source.getSecondOfMinute(), source.getMillisOfSecond() * 1_000_000);

        System.out.println("[[[source = " + source);
        System.out.println("[[[result = " + result);

    }

    @Test
    public void testJavaToJoda() {

        java.time.LocalDateTime source = java.time.LocalDateTime.now();
        org.joda.time.LocalDateTime result = new org.joda.time.LocalDateTime(source.getYear(), source.getMonthValue(), source.getDayOfMonth(), source.getHour(), source.getMinute(), source.getSecond(), source.getNano() / 1_000_000);

        System.out.println("[[[source = " + source);
        System.out.println("[[[result = " + result);
    }
}
