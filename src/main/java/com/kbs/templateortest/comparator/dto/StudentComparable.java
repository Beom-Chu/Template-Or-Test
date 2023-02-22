package com.kbs.templateortest.comparator.dto;

import lombok.*;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentComparable implements Comparable<StudentComparable>{

    private int id;
    private String name;
    private int age;

    @Override
    public int compareTo(@NotNull StudentComparable o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "\n Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
