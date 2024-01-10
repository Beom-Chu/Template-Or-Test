package com.kbs.templateortest.lombok.tostring.exclude.dto;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class TeamEx {
    private String name;
    @ToString.Exclude
    private List<MemberEx> members = new ArrayList<>();
}
