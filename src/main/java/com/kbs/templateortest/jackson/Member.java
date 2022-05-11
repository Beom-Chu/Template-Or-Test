package com.kbs.templateortest.jackson;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) /* 값 존재 유무에 따른 직렬화 필드 포함 여부 */
//@JsonIgnoreProperties({"id","name"}) /* 직렬화 제외(class단위) */
//@JsonPropertyOrder({"email", "age", "name", "id"}) /* 직렬화 순서 설정 */
public class Member {

//    @JsonIgnore /* 직렬화 제외(필드단위) */
    private Integer id;

//    @JsonAlias({"full_name","name2"}) /* 역직렬화시 json 필드명 여러개를 하나의 객체 필드로 설정 */
    private String name;
    private Integer age;
    private String email;

    @JsonProperty("phone-no") /* 직렬화시 사용할 필드명 설정 */
    private String phoneNumber;
    private Gender gender;

//    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss") /* 날짜, 시간 직렬화시 포멧 설정 */
    private LocalDateTime regDate;
}
