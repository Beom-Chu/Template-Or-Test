package com.kbs.templateortest.comparator.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ActivityDto {
    Long id;
    Set<ActivityDataDto> activityDatas;

    public ActivityDto(int id, ActivityDataDto activityDatas) {
        this.id = (long)id;
        Set<ActivityDataDto> set = new HashSet<>();
        set.add(activityDatas);
        this.activityDatas = set;
    }
}