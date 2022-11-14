package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;

public class ZonedDateTimeTest {

    @Test
    public void test() {

        ZonedDateTime startOfMonth = ZonedDateTime.now().with(TemporalAdjusters.firstDayOfMonth());

        System.out.println("[[[startOfMonth = " + startOfMonth);

    }
}
