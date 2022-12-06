package com.kbs.templateortest.innerclasstest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class NonStaticInnerClassTest {

    /*
    에러 재현
    com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.kbs.templateortest.innerclasstest.OuterClass$InnerClass`: non-static inner classes like this can only by instantiated using default, no-argument constructor
     */
    @Test
    public void test() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = "{\"no\":1,\"name\":\"oName\",\"innerClass\":[{\"no\":1,\"name\":\"iName\"}]}";

        OuterClass outerClass1 = objectMapper.readValue(jsonString, OuterClass.class);

        System.out.println("[[[outerClass1 = " + outerClass1);
    }
}
