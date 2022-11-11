package com.kbs.templateortest.jackson.infinite.recursion;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


public class ParentDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static public class Annotate {
        private int no;
        private String name;
        @JsonManagedReference
        private List<ChildDto.Annotate> childDto = new ArrayList<>();
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static public class NoAnnotate {
        private int no;
        private String name;
        private List<ChildDto.NoAnnotate> childDto = new ArrayList<>();
    }
}
