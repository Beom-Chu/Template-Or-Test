package com.kbs.templateortest.time;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * ChronoUnit.DAYS 로 until 사용시 단순히 날짜의 차이로만 계산하지 않고
 * 24시간당 1일 차이로 계산함.
 */
public class TemporalUntilTest {

    @Test
    void temporalUntilTest(){

        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime nowZero = ZonedDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        ZonedDateTime testDate = ZonedDateTime.of(2022, 3, 9, 0, 0, 0, 0, ZoneId.of("Asia/Seoul"));
        ZonedDateTime comparisonDate = ZonedDateTime.of(2022, 3, 9, 23, 59, 59, 0, ZoneId.of("Asia/Seoul"));

        System.out.println(now.until(comparisonDate, ChronoUnit.DAYS));
        System.out.println(nowZero.until(comparisonDate, ChronoUnit.DAYS));
        System.out.println(testDate.until(comparisonDate, ChronoUnit.DAYS));
    }

    @Test
    void timeTest(){
        String effectiveFromDatetime = "2022-06-30T23:59:59.999999999Z";
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(effectiveFromDatetime);
        System.out.println("[[[zonedDateTime = " + zonedDateTime);
    }
}
