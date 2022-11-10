package com.kbs.templateortest.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;


/**
 * @JsonAnyGetter
 * Map 타입을 직렬화 할때 Map에 들어있는 요소들이 상위의 객체로 만들어진다.
 * Map 타입만 사용 가능.
 * getter 메소드 위에 사용.
 * 역직렬화는 보장하지 못함.
 */
public class JsonAnyGetterDto {

    @Setter
    @ToString
    public static class NoAnnotate {
        private int id;
        private Map<String, String> properties = new HashMap<>();

        public Map<String, String> getProperties() {
            return properties;
        }

        public int getId() {
            return id;
        }
    }

    @Setter
    @ToString
    public static class Annotate {
        private int id;
        private Map<String, String> properties = new HashMap<>();

        @JsonAnyGetter
        public Map<String, String> getProperties() {
            return properties;
        }

        public int getId() {
            return id;
        }
    }
}
