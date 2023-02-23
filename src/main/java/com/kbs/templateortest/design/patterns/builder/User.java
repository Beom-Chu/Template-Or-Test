package com.kbs.templateortest.design.patterns.builder;

/*
 * 빌더 패턴 장점
1. 생성자의 인자가 많아지는 것을 방지할 수 있습니다.
2. 인자의 순서를 신경쓰지 않아도 됩니다.
3. 객체의 일관성을 유지할 수 있습니다.
 */
public class User {
    private final String name;
    private final String email;
    private final int age;
    private final String phone;

    public User(UserBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.phone = builder.phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private int age;
        private String phone;

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
