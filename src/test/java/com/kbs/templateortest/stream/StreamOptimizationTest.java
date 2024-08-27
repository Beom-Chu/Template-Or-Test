package com.kbs.templateortest.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

// Stream 최적화
public class StreamOptimizationTest {

    static class Data {
        private final int value;

        public Data(int value) {
            this.value = value;
        }

        public void runOperationA() {
            System.out.printf("데이터 %d의 작업A%n", value);
        }

        public void runOperationB() {
            System.out.printf("데이터 %d의 작업B%n", value);
        }

        public void runOperationC() {
            System.out.printf("데이터 %d의 작업C%n", value);
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Data{" + value + '}';
        }
    }

    @Test
    @DisplayName("루프퓨전")
    void testLoopFusion() {

        Stream.of(new Data(1), new Data(2), new Data(3))
                .peek(Data::runOperationA)
                .peek(Data::runOperationB)
                .forEach(Data::runOperationC);

        System.out.println();

        List<Data> dataList = List.of(new Data(1), new Data(2), new Data(3));
        for (Data data : dataList) {
            data.runOperationA();
            data.runOperationB();
            data.runOperationC();
        }
    }

    @Test
    @DisplayName("쇼트서킷")
    void testShortCircuit() {

        List<Data> list = Stream.of(new Data(1), new Data(2), new Data(3))
                .filter(o -> o.value >= 2)
                .peek(Data::runOperationA)
                .peek(Data::runOperationB)
                .peek(Data::runOperationC)
                .limit(1)
                .toList();
        System.out.println(list);

        System.out.println();

        List<Data> dataList2 = List.of(new Data(1), new Data(2), new Data(3));
        int maxSize = 1;
        int count = 0;
        List<Data> result = new ArrayList<>();
        for (Data data : dataList2) {
            if (data.value >= 2) {
                data.runOperationA();
                data.runOperationB();
                data.runOperationC();
                result.add(data);
                count++;
                if(count >= maxSize) {
                    break;
                }
            }
        }
    }

    @Test
    @DisplayName("루프퓨전이 발생하지 않는 경우")
    void testNotLoopFusion() {

        Stream.of(new Data(2), new Data(1), new Data(3))
                .peek(Data::runOperationA)
                .peek(Data::runOperationB)
                .limit(1)
                .forEach(Data::runOperationC);

        System.out.println();

        Stream.of(new Data(2), new Data(1), new Data(3))
                .peek(Data::runOperationA)
                .peek(Data::runOperationB)
                .sorted(Comparator.comparingInt(Data::getValue))
                .limit(1)
                .forEach(Data::runOperationC);

        System.out.println();
    }
}
