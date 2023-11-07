package com.kbs.templateortest.time;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class ZonedDateTimeTest {

    @Test
    public void test() {

        ZonedDateTime startOfMonth = ZonedDateTime.now().with(TemporalAdjusters.firstDayOfMonth());

        System.out.println("[[[startOfMonth = " + startOfMonth);

    }

    @Test
    void test2() {
        ZonedDateTime firstOfWeek = ZonedDateTime.now().with(ChronoField.DAY_OF_WEEK, 1);
        ZonedDateTime lastMonday = firstOfWeek.minusWeeks(1).truncatedTo(ChronoUnit.DAYS);
        ZonedDateTime twoMondaysAgo = lastMonday.minusWeeks(1).truncatedTo(ChronoUnit.DAYS);

        System.out.println("[[[firstOfWeek = " + firstOfWeek);
        System.out.println("[[[lastMonday = " + lastMonday);
        System.out.println("[[[twoMondaysAgo = " + twoMondaysAgo);
    }
}
