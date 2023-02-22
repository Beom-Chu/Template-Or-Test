package com.kbs.templateortest.comparator;

import com.kbs.templateortest.comparator.dto.StudentComparable;
import com.kbs.templateortest.comparator.dto.StudentComparator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableComparatorTest {

    @Test
    public void testComparable() {
        List<StudentComparable> studentList = new ArrayList<>();

        studentList.add(new StudentComparable(4, "John", 21));
        studentList.add(new StudentComparable(2, "Sarah", 19));
        studentList.add(new StudentComparable(1, "Mike", 20));
        studentList.add(new StudentComparable(3, "Emily", 18));

        // Comparable을 이용하여 기본 정렬 기준으로 정렬합니다.
        Collections.sort(studentList);

        System.out.println("기본 정렬 기준으로 정렬된 학생들: " + studentList);
    }

    @Test
    public void testComparator() {
        List<StudentComparator> studentList = new ArrayList<>();

        studentList.add(new StudentComparator(4, "John", 21));
        studentList.add(new StudentComparator(2, "Sarah", 19));
        studentList.add(new StudentComparator(1, "Mike", 20));
        studentList.add(new StudentComparator(3, "Emily", 18));

        // Comparator를 이용하여 나이순으로 정렬합니다.
        Comparator<StudentComparator> sortByAge = Comparator.comparingInt(StudentComparator::getAge);
        Collections.sort(studentList, sortByAge);

        System.out.println("나이순으로 정렬된 학생들: " + studentList);
    }
}
