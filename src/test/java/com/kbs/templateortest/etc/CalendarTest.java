package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Calendar;
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

    @Test
    public void test2() {
        String[] weekDay = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
        Calendar cal = Calendar.getInstance();
        int num = cal.get(Calendar.DAY_OF_WEEK)-1;

        System.out.println("[[[weekDay[num] = " + weekDay[num]);


        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        c.add(c.DATE,-1);

        String format = formatter.format(c.getTime());
        System.out.println("[[[format = " + format);

    }

    @Test
    public void test3() {

        System.out.println("[[[format = " + getLastWeekMonday("yyyy-MM-dd"));

        System.out.println("[[[format = " + getLastWeekSunday("yyyy-MM-dd"));
    }

    private static String getLastWeekMonday(String format){
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format);

        Calendar c = Calendar.getInstance();
        c.add(c.DATE,-7);
        c.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);

        return formatter.format(c.getTime());
    }

    private static String getLastWeekSunday(String format){
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format);

        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);

        return formatter.format(c.getTime());
    }

    @Test
    public void test4() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.DATE,8);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(calendar.toInstant(), TimeZone.getDefault().toZoneId()).with(LocalTime.MIN);

        System.out.println("[[[zonedDateTime = " + zonedDateTime);
    }
}
