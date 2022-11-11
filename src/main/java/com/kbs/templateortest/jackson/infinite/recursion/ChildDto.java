package com.kbs.templateortest.jackson.infinite.recursion;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ChildDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class Annotate {
        private int id;
        private String name;
        @JsonBackReference
        private ParentDto.Annotate parentDto;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static public class NoAnnotate {
        private int id;
        private String name;
        private ParentDto.NoAnnotate parentDto;
    }
}
