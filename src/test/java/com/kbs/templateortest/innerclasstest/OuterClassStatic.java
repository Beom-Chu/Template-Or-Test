package com.kbs.templateortest.innerclasstest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class OuterClassStatic {

    private int no;
    private String name;
    private List<InnerClass> innerClass;

    @Data @AllArgsConstructor @NoArgsConstructor
    public static class InnerClass {
        private int no;
        private String name;
    }
}
