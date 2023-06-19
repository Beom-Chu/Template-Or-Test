package com.kbs.templateortest.etc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateCompareTest {

    SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
    @Test
    public void test() {

        String stringDate = "20230322";
        int days = 90;

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();

        Date startDate = null;
        try {
            startDate = transFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(startDate);
        cal.add(Calendar.DATE, days);

        Date compareDate = cal.getTime();

        int compare = today.compareTo(compareDate);

        System.out.println("[[[compare <= 0 = " + (compare <= 0));

    }

    @Test
    @DisplayName("두 날짜의 차이 구하기")
    public void test2() {

        String stringDate = "20230322";
        LocalDate targetDate = LocalDate.parse(stringDate, DateTimeFormatter.BASIC_ISO_DATE);

        /* Period를 사용해서 두 날짜의 차이 구하기 */
        Period period = Period.between(targetDate, LocalDate.now());

        System.out.println("[[[Years() = " + period.getYears());
        System.out.println("[[[months = " + period.getMonths());
        System.out.println("[[[days = " + period.getDays());




        /* ChronoUnit 사용이 가장 심플한 코드  */
        long diffInDays = ChronoUnit.DAYS.between(targetDate, LocalDate.now());

        System.out.println("[[[diffInDays = " + diffInDays);
    }
}
