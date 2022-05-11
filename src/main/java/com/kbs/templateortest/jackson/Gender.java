package com.kbs.templateortest.jackson;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {
    MAN("남성"), WOMAN("여성");

    private String name;

    Gender(String name){
        this.name = name;
    }

//    @JsonValue /* 직렬화시 해당 메서드 결과값으로 직렬화 */
    public String getName() {
        return name;
    }
}
