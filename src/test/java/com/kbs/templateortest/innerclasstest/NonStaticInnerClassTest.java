package com.kbs.templateortest.innerclasstest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NonStaticInnerClassTest {

    /*
    에러 재연
    com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.kbs.templateortest.innerclasstest.OuterClass$InnerClass`: non-static inner classes like this can only by instantiated using default, no-argument constructor
     */
    @Test
    @DisplayName("에러 재연")
    public void test() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = "{\"no\":1,\"name\":\"oName\",\"innerClass\":[{\"no\":1,\"name\":\"iName\"}]}";

        OuterClass outerClass = objectMapper.readValue(jsonString, OuterClass.class);

        System.out.println("[[[outerClass = " + outerClass);
    }

    @Test
    @DisplayName("에러 해결")
    public void testStatic() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = "{\"no\":1,\"name\":\"oName\",\"innerClass\":[{\"no\":1,\"name\":\"iName\"}]}";

        OuterClassStatic outerClassStatic = objectMapper.readValue(jsonString, OuterClassStatic.class);

        System.out.println("[[[outerClassStatic = " + outerClassStatic);
    }

    @Test
    public void test2() {

        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

        outerClass.setName("oName");
        outerClass.setNo(1);

        List<OuterClass.InnerClass> innerClasses = new ArrayList<>();

        innerClass.setNo(1);
        innerClass.setName("iName");

        innerClasses.add(innerClass);

        outerClass.setInnerClass(innerClasses);

        System.out.println("[[[outerClass = " + outerClass);
    }

    @Test
    public void test3() {

        OuterClassStatic outerClass = new OuterClassStatic();
        OuterClassStatic.InnerClass innerClass = new OuterClassStatic.InnerClass();

        outerClass.setName("oName");
        outerClass.setNo(1);

        List<OuterClassStatic.InnerClass> innerClasses = new ArrayList<>();

        innerClass.setNo(1);
        innerClass.setName("iName");

        innerClasses.add(innerClass);

        outerClass.setInnerClass(innerClasses);

        System.out.println("[[[outerClass = " + outerClass);
    }
}
