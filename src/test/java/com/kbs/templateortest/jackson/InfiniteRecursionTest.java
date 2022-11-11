package com.kbs.templateortest.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kbs.templateortest.jackson.infinite.recursion.ChildDto;
import com.kbs.templateortest.jackson.infinite.recursion.ParentDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursionTest {

    @Test
    @DisplayName("@JsonManagedReference, @JsonBackReference 어노테이션 붙인 경우")
    public void testAnnotate() throws JsonProcessingException {

        ParentDto.Annotate parentDto = new ParentDto.Annotate(1, "kbs", null);

        List<ChildDto.Annotate> childDtos = new ArrayList<>();
        childDtos.add(new ChildDto.Annotate(1, "ksy" , parentDto));
        childDtos.add(new ChildDto.Annotate(2, "kdy" , parentDto));

        parentDto.setChildDto(childDtos);

        String json = new ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(parentDto);

        System.out.println("[[[json = " + json);
    }

    @Test
    @DisplayName("어노테이션이 없는 경우")
    public void testNoAnnotate() throws JsonProcessingException {

        ParentDto.NoAnnotate parentDto = new ParentDto.NoAnnotate(1, "kbs", null);

        List<ChildDto.NoAnnotate> childDtos = new ArrayList<>();
        childDtos.add(new ChildDto.NoAnnotate(1, "ksy" , parentDto));
        childDtos.add(new ChildDto.NoAnnotate(2, "kdy" , parentDto));

        parentDto.setChildDto(childDtos);

        String json = new ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(parentDto);

        System.out.println("[[[json = " + json);
    }

}
