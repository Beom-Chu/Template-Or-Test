package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.TimeZone;

public class CalendarTest {

    @Test
    public void test() {

//        String[] availableIDs = TimeZone.getAvailableIDs();
//        System.out.println("[[[availableIDs = " + Arrays.toString(availableIDs));

        int year = 2022;
        int month = 11;

        ZoneId zoneId = (ZoneId.of("Asia/Seoul"));

        java.util.Calendar calendar = java.util.Calendar.getInstance();

        calendar.set(java.util.Calendar.YEAR, year); //입력받은 년도로 세팅
        calendar.set(java.util.Calendar.MONTH, month); //입력받은 월로 세팅

        calendar.set(year, month - 1, 1); //입력받은 월의 1일로 세팅(month는 0이 1월이므로 -1)

        int dateCount = calendar.getActualMaximum(java.util.Calendar.DATE); //해당 월 마지막 날짜

        System.out.println("[[[ZonedDateTime.ofInstant(calendar.toInstant(), zoneId).with(LocalTime.MIN)) = " + ZonedDateTime.ofInstant(calendar.toInstant(), zoneId).with(LocalTime.MIN));
        calendar.add(java.util.Calendar.DATE, dateCount - 1);  //입력받은 월의 말일로 세팅
        System.out.println("[[[ZonedDateTime.ofInstant(calendar.toInstant(), zoneId).with(LocalTime.MAX)) = " + ZonedDateTime.ofInstant(calendar.toInstant(), zoneId).with(LocalTime.MAX));
        System.out.println("[[[dateCount = " + dateCount);


        calendar.set(year, month - 1, 1); //입력받은 월의 1일로 재세팅

        System.out.println("[[[ZonedDateTime.ofInstant(calendar.toInstant(), zoneId).with(LocalTime.MIN) = " + ZonedDateTime.ofInstant(calendar.toInstant(), zoneId).with(LocalTime.MIN));
        System.out.println("[[[ZonedDateTime.ofInstant(calendar.toInstant(), zoneId).with(LocalTime.MAX = " + ZonedDateTime.ofInstant(calendar.toInstant(), zoneId).with(LocalTime.MAX).withNano(0));
    }
}
