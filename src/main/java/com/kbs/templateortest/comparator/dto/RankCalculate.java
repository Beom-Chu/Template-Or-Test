package com.kbs.templateortest.comparator.dto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RankCalculate implements Comparator<ActivityDto> {
    @Override
    public int compare(ActivityDto  fruite1, ActivityDto  fruite2)
    {
        List<ActivityDataDto> activityDataDtoList1 = new ArrayList<>(fruite1.getActivityDatas());
        List<ActivityDataDto> activityDataDtoList2 = new ArrayList<>(fruite2.getActivityDatas());

        System.out.println("[[[RankCalculate = " + Long.parseLong(activityDataDtoList1.get(0).getActivityDataValue()) +","+Long.parseLong(activityDataDtoList2.get(0).getActivityDataValue()));

        if (activityDataDtoList1.size() == 0) {
            return -1;
        } else if (activityDataDtoList2.size() == 0) {
            return 1;
        } else if (Long.parseLong(activityDataDtoList1.get(0).getActivityDataValue()) <= Long.parseLong(activityDataDtoList2.get(0).getActivityDataValue())) {
            return -1;
        } else {
            return  1;
        }

/* IllegalArgumentException: Comparison method violates its general contract! 에러 해결 코드 */
//        if (activityDataDtoList1.size() == 0) {
//            return -1;
//        } else if (activityDataDtoList2.size() == 0) {
//            return 1;
//        } else {
//            return (int) (Long.parseLong(activityDataDtoList1.get(0).getActivityDataValue()) - Long.parseLong(activityDataDtoList2.get(0).getActivityDataValue()));
//        }
    }
}
