package com.kbs.templateortest.etc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTypeConversionTest {

    @Test
    @DisplayName("testDateToTimeLocalDate : Date -> Instant -> ZonedDateTime -> LocalDate, LocalDateTime")
    public void testDateToTimeLocalDate() {

        // 1. Date 객체 생성 (현재날짜)
        Date date = new Date();

        // 2. Date -> LocalDate
        LocalDate localDate = date.toInstant()   // Date -> Instant
                .atZone(ZoneId.systemDefault())  // Instant -> ZonedDateTime
                .toLocalDate(); // ZonedDateTime -> LocalDate

        // 3. Date -> LocalDateTime
        LocalDateTime localDateTime = date.toInstant() // Date -> Instant
                .atZone(ZoneId.systemDefault()) // Instant -> ZonedDateTime
                .toLocalDateTime(); // ZonedDateTime -> LocalDateTime

        // 4. Date, LocalDate, LocalDateTime 출력
        System.out.println(date);  // Sun Jun 20 21:09:20 KST 2021
        System.out.println(localDate);  // 2021-06-20
        System.out.println(localDateTime);  // 2021-06-20T21:09:20.461
    }

    @Test
    @DisplayName("testDateToSqlDate : Date -> java.sql.Date, java.sql.Timestamp -> LocalDate, LocalDateTime")
    public void testDateToSqlDate() {
        // 1. Date 객체 생성 (현재날짜)
        Date date = new Date();

        // 2. Date -> LocalDate
        LocalDate localDate = new java.sql.Date(date.getTime())  // java.util.Date -> java.sql.Date
                .toLocalDate();  // java.sql.Date -> LocalDate

        // 3. Date -> LocalDateTime
        LocalDateTime localDateTime = new java.sql.Timestamp(date.getTime())  // java.util.Date -> java.sql.Timestamp
                .toLocalDateTime();  // java.sql.Timestamp -> LocalDateTime

        // 4. Date, LocalDate, LocalDateTime 출력
        System.out.println(date);  // Sun Jun 20 21:09:20 KST 2021
        System.out.println(localDate);  // 2021-06-20
        System.out.println(localDateTime);  // 2021-06-20T21:09:20.461
    }

    @Test
    @DisplayName("testDateToTimeLocalDateJava9 : LocalDate.ofInstant(), LocalDateTime.ofInstant() : Java 9 이상")
    public void testDateToTimeLocalDateJava9() {
        // 1. Date 객체 생성 (현재날짜)
        Date date = new Date();

        // 2. Date -> LocalDate
        LocalDate localDate = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());

        // 3. Date -> LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

        // 4. Date, LocalDate, LocalDateTime 출력
        System.out.println(date);  // Sun Jun 20 21:09:20 KST 2021
        System.out.println(localDate);  // 2021-06-20
        System.out.println(localDateTime);  // 2021-06-20T21:09:20.461
    }

    @Test
    @DisplayName("testLocalDateTimeToDate : java.sql.Timestamp.valueOf()")
    public void testLocalDateTimeToDate() {
        // 1. LocalDateTime 객체 생성(현재 시간)
        LocalDateTime localDateTime = LocalDateTime.now();

        // 2. LocalDateTime -> Date 변환
        Date date = java.sql.Timestamp.valueOf(localDateTime);
        /*
        java.sql.Timestamp 클래스는 java.util.Date 클래스의 자식 클래스이므로,
        Timestamp 객체를 Date 객체로 형변환 할 수 있습니다.
         */

        // 3. LocalDateTime, Date 결과 출력
        System.out.println(localDateTime);  // 2021-06-20T21:45:14.172849300
        System.out.println(date);  // 2021-06-20 21:45:14.1728493
    }

    @Test
    @DisplayName("testLocalDateTimeToDate2 : java.util.Date.from()")
    public void testLocalDateTimeToDate2() {
        // 1. LocalDateTime 객체 생성(현재 시간)
        LocalDateTime localDateTime = LocalDateTime.now();

        // 2. LocalDateTime -> Date 변환
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        // 3. LocalDateTime, Date 결과 출력
        System.out.println(localDateTime);  // 2021-06-20T21:45:14.172849300
        System.out.println(date);  // 2021-06-20 21:45:14.1728493
    }

    @Test
    @DisplayName("testLocalDateToDate : java.sql.Date.valueOf()")
    public void testLocalDateToDate() {
        // 1. LocalDate 객체 생성(현재 시간)
        LocalDate localDate = LocalDate.now();

        // 2. LocalDate -> Date 변환
        Date date = java.sql.Date.valueOf(localDate);
        /*
        java.sql.Date 클래스는 java.util.Date 클래스의 자식 클래스이므로,
        java.sql.Date.valueOf() 메소드가 리턴하는 값이 java.sql.Date 클래스이지만,
        자동으로 타입 캐스팅 되었습니다.
         */

        // 3. LocalDate, Date 결과 출력
        System.out.println(localDate); // 2021-06-20
        System.out.println(date); // 2021-06-20
    }

    @Test
    @DisplayName("testLocalDateToDate2 : java.util.Date.from()")
    public void testLocalDateToDate2() {
        // 1. LocalDate 객체 생성(현재 시간)
        LocalDate localDate = LocalDate.now();

        // 2. LocalDate -> Date 변환
        Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        // 3. LocalDate, Date 결과 출력
        System.out.println(localDate); // 2021-06-20
        System.out.println(date); // Sun Jun 20 00:00:00 KST 2021
    }
}
