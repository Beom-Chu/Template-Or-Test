package com.kbs.templateortest.lombok.tostring.exclude.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Team {
    private String name;
    private List<Member> members = new ArrayList<>();
}
