package com.kbs.templateortest.valid.vo;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddUserRequest {

    @Email
    private String email;

    @NotBlank
    private String pw;

    @NotNull
    private UserRole userRole;

    @Min(12)
    private int age;
}
