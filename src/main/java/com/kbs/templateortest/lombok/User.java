package com.kbs.templateortest.lombok;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private int age;

    /* boolean 기본 타입의 경우 롬복이 getter, setter를 만들 때
    get필드명, set필드명 형식으로 만들어지지 않음.
    이 때문에 Controller에서 전달 받을때 해당 값이 정상적으로 들어가지 않는 경우 발생.

    public boolean isAdult() {
        return this.isAdult;
    }
    public void setAdult(final boolean isAdult) {
        this.isAdult = isAdult;
    }
     */
    private boolean isAdult;

    /* Boolean 참조 타입인 경우 롬복이 일반적인 방식으로 getter, setter 만들어짐 */
    private Boolean isKorean;

    private boolean isTest;

    public void setIsTest(boolean isTest) {
        this.isTest = isTest;
    }
    public boolean getIsTest(){
        return this.isTest;
    }
}
