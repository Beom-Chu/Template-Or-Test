package com.kbs.templateortest.time;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;

public class YearMonthTest {

    @Test
    public void test() {
        LocalDate yesterday = LocalDate.now(ZoneId.of("Asia/Seoul")).minusDays(1);
        YearMonth yesterdayYearMonth = YearMonth.from(yesterday);
        System.out.println("[[[yesterday = " + yesterday);
        System.out.println("[[[yesterdayYearMonth = " + yesterdayYearMonth);

        int dayOfMonth1 = yesterdayYearMonth.atEndOfMonth().getDayOfMonth();
        int dayOfMonth2 = yesterday.getDayOfMonth();

        System.out.println("[[[dayOfMonth1 = " + dayOfMonth1);
        System.out.println("[[[dayOfMonth2 = " + dayOfMonth2);
    }

    @Test
    public void method() {

        YearMonth now = YearMonth.now();    /* 현재년월 */
        YearMonth ofYearMonth = YearMonth.of(2022, 7); /* 지정년월 */
        YearMonth fromYearMonth = YearMonth.from(LocalDate.now()); /* LocalDate의 년월 */

        System.out.println("[[[now = " + now);
        System.out.println("[[[ofYearMonth = " + ofYearMonth);
        System.out.println("[[[fromYearMonth = " + fromYearMonth);

        LocalDate endOfMonth = now.atEndOfMonth(); /* 해당년월의 마지막 날짜 */
        int monthValue = now.getMonthValue(); /* 월 숫자 */
        Month month = now.getMonth(); /* 월의 Month 객체 */
        LocalDate atDay = now.atDay(10); /* 년월에 일자를 붙여서 LocalDate로 */

        System.out.println("[[[endOfMonth = " + endOfMonth);
        System.out.println("[[[monthValue = " + monthValue);
        System.out.println("[[[month = " + month);
        System.out.println("[[[atDay = " + atDay);

        int compareTo = now.compareTo(fromYearMonth); /* 같은지 비교 : 같으면 0 , 작으면 음수, 크면 양수 */
        boolean after = now.isAfter(ofYearMonth); /* 대상이 비교값보다 이후 인지 */
        boolean before = now.isBefore(ofYearMonth); /* 대상이 비교값보다 이전 인지 */

        System.out.println("[[[compareTo = " + compareTo);
        System.out.println("[[[after = " + after);
        System.out.println("[[[before = " + before);
    }
}
