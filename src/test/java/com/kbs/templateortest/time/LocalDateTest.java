package com.kbs.templateortest.time;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

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

    @Test
    @DisplayName("주말을 다음 월요일로 변경 메서드 테스트")
    public void testChangeWeekendToMonday() {
        LocalDate date0622 = LocalDate.of(2023, 6, 22); /*목*/
        LocalDate date0623 = LocalDate.of(2023, 6, 23); /*금*/
        LocalDate date0624 = LocalDate.of(2023, 6, 24); /*토*/
        LocalDate date0625 = LocalDate.of(2023, 6, 25); /*일*/
        LocalDate date0626 = LocalDate.of(2023, 6, 26); /*월*/
        LocalDate date0627 = LocalDate.of(2023, 6, 27); /*화*/

        LocalDate date0430 = LocalDate.of(2023, 4, 30); /*일:다음달로 넘어감*/

        System.out.println("[[[date0622 = " + changeWeekendToMonday(date0622));
        System.out.println("[[[date0623 = " + changeWeekendToMonday(date0623));
        System.out.println("[[[date0624 = " + changeWeekendToMonday(date0624));
        System.out.println("[[[date0625 = " + changeWeekendToMonday(date0625));
        System.out.println("[[[date0626 = " + changeWeekendToMonday(date0626));
        System.out.println("[[[date0627 = " + changeWeekendToMonday(date0627));

        System.out.println("[[[date0430 = " + changeWeekendToMonday(date0430));

    }
    public Date changeWeekendToMonday(LocalDate executeDate) {

        DayOfWeek dayOfWeek = executeDate.getDayOfWeek();
        if(dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            executeDate = executeDate.plusDays(2);
        } else if(dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            executeDate = executeDate.plusDays(1);
        }
        return Date.valueOf(executeDate);
    }


    @Test
    public void testTemporalAdjusters() {
        LocalDate executeDate = LocalDate.now();

        LocalDate effectiveDateFrom = executeDate.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth()); // 해당 월의 첫날
        LocalDate effectiveDateTo = executeDate.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()); // 해당 월의 마지막 날

        System.out.println("[[[effectiveDateFrom = " + effectiveDateFrom);
        System.out.println("[[[effectiveDateTo = " + effectiveDateTo);
    }

    @Test
    @DisplayName("WeekFields를 활용해서 특정년도의 주차수를 구하기")
    public void testWeekFields() {

        LocalDate prevWeekDate = LocalDate.now().minusWeeks(1);
        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        String standardWeek = "" + prevWeekDate.getYear() + prevWeekDate.get(weekFields.weekOfWeekBasedYear());

        String format = String.format("%d%02d", prevWeekDate.getYear(), prevWeekDate.get(weekFields.weekOfWeekBasedYear()));

        System.out.println("[[[standardWeek = " + standardWeek);
        System.out.println("[[[format = " + format);
    }
}
