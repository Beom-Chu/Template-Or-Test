package com.kbs.templateortest.etc;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GuavaTest {
    @Test
    public void test(){

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,0);

        List<List<Integer>> partition = Lists.partition(list, 3);

        System.out.println("[[[partition = " + partition);
    }
}
