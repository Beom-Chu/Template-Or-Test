package com.kbs.templateortest.time;

import org.junit.jupiter.api.Test;

/*

WARN 11932 --- [  restartedMain] o.s.data.convert.CustomConversions       : Registering converter from class java.time.LocalDateTime to class org.joda.time.LocalDateTime as reading converter although it doesn't convert from a store-supported type; You might want to check your annotation setup at the converter implementation

해당 경고 문구는 spring-boot-starter-data-mongodb 와 joda-time 라이브러리를 같이 사용하는 경우 발생 합니다.
spring-boot-starter-data-mongodb 에 포함되어 있는 org.springframework.data:spring-data-commons:2.7.3 종속 요소에서
변환 가능한 타입들의  converter를 설정하게 되는데, 해당 타입은 지원하지 않기 때문에 발생하는 것으로 보입니다.
java.time.LocalDateTime -> org.joda.time.LocalDateTime

 */
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
