package com.kbs.templateortest.comparator;

import com.kbs.templateortest.comparator.dto.ActivityDataDto;
import com.kbs.templateortest.comparator.dto.ActivityDto;
import com.kbs.templateortest.comparator.dto.RankCalculate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ComparatorTest {


    @Test
    @DisplayName("IllegalArgumentException: Comparison method violates its general contract! 에러 재현")
    public void test(){

        List<ActivityDto> activityDtos = new ArrayList<>();
        activityDtos.add(new ActivityDto(37232949,new ActivityDataDto("8")));
        activityDtos.add(new ActivityDto(37217395,new ActivityDataDto("8")));
        activityDtos.add(new ActivityDto(37217882,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37227606,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37235862,new ActivityDataDto("54")));
        activityDtos.add(new ActivityDto(37212424,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37205644,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37216531,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37180065,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37228899,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37206166,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37191244,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37221318,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37221157,new ActivityDataDto("221")));
        activityDtos.add(new ActivityDto(37221157,new ActivityDataDto("221")));
        activityDtos.add(new ActivityDto(37228899,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37206166,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37191244,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37227606,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37221318,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37217882,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37216531,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37180065,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37212424,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37205644,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37232949,new ActivityDataDto("8")));
        activityDtos.add(new ActivityDto(37217395,new ActivityDataDto("8")));
        activityDtos.add(new ActivityDto(37180065,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37221318,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37217882,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37212424,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37235862,new ActivityDataDto("54")));
        activityDtos.add(new ActivityDto(37205644,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37228899,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37227606,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37206166,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37191244,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37216531,new ActivityDataDto("36")));
        activityDtos.add(new ActivityDto(37209385,new ActivityDataDto("69")));
        activityDtos.add(new ActivityDto(37235862,new ActivityDataDto("54")));
        activityDtos.add(new ActivityDto(37209385,new ActivityDataDto("69")));
        activityDtos.add(new ActivityDto(37221157,new ActivityDataDto("221")));
        activityDtos.add(new ActivityDto(37232949,new ActivityDataDto("8")));
        activityDtos.add(new ActivityDto(37217395,new ActivityDataDto("8")));
        activityDtos.add(new ActivityDto(37209385,new ActivityDataDto("69")));



        activityDtos.sort(new RankCalculate());


        for(ActivityDto dto : activityDtos) {
            System.out.println("[[[dto = " + dto);
        }
    }
}
