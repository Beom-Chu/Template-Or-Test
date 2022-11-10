package com.kbs.templateortest.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JsonAnyGetterTest {

    @Test
    @DisplayName("JsonAnyGetter Test")
    public void testJsonAnyGetter() throws JsonProcessingException {

        JsonAnyGetterDto.NoAnnotate noAnnotate = new JsonAnyGetterDto.NoAnnotate();
        noAnnotate.setId(1);
        noAnnotate.getProperties().put("name","ksy");
        noAnnotate.getProperties().put("age","1");

        printJson(noAnnotate);

        JsonAnyGetterDto.Annotate annotateDto = new JsonAnyGetterDto.Annotate();
        annotateDto.setId(2);
        annotateDto.getProperties().put("name","ksy");
        annotateDto.getProperties().put("age","1");

        printJson(annotateDto);
    }

    public void printJson(Object dto) throws JsonProcessingException {
        System.out.println("[[[Pojo = " + dto);

        String json = new ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(dto);

        System.out.println("[[[json = " + json);

        Object obj = new ObjectMapper().readValue(json, dto.getClass());
        System.out.println("[[[obj = " + obj);
    }
}
