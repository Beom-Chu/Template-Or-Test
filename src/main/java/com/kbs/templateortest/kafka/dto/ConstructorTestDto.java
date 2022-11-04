package com.kbs.templateortest.kafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * Kafka 메시지 객체에 기본 생성자가 없거나
 * 파라미터가 있는 생성자의 매개변수 선언 부분에 @JsonProperty 가 없는 경우에
 * 아래와 같은 에러가 발생!!
 * org.springframework.kafka.listener.ListenerExecutionFailedException: Listener failed; nested exception is org.springframework.kafka.support.converter.ConversionException: Failed to convert from JSON; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.kbs.templateortest.kafka.dto.ConstructorTestDto` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
 */

@Getter
@ToString
public class ConstructorTestDto {
    private Long id;
    private String str;
    private Long number;


    public ConstructorTestDto(Long id, String str, Long number) {
        this.id = id;
        this.str = str;
        this.number = number;
    }

//    public ConstructorTestDto(@JsonProperty("id") Long id, @JsonProperty("str") String str, @JsonProperty("number") Long number) {
//        this.id = id;
//        this.str = str;
//        this.number = number;
//    }
}
