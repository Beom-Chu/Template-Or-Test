package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

public class StringJoinerTest {

    @Test
    public void test() {

        String arrivalDate = "20230725";
        String targetDate = "20230625";

        StringJoiner joiner = new StringJoiner("||");

        String arrivalDateYear = arrivalDate.substring(0, 4);
        String arrivalDateMonth = arrivalDate.substring(4, 6);
        String arrivalDateDay = arrivalDate.substring(6,8);
        String targetDateYear = targetDate.substring(0, 4);
        String targetDateMonth = targetDate.substring(4, 6);
        String targetDateDay = targetDate.substring(6, 8);

        joiner.add(arrivalDateYear).add(arrivalDateMonth).add(arrivalDateDay)
                .add(arrivalDateYear).add(arrivalDateMonth).add(arrivalDateDay)
                .add(targetDateYear).add(targetDateMonth).add(targetDateDay);

        String result = joiner.toString();

        System.out.println("[[[result = " + result);
    }
}
