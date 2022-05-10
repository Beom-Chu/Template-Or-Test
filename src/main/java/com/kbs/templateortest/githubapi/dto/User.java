package com.kbs.templateortest.githubapi.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String login;
    private Long id;
    @SerializedName("avatar_url")
    private String avatarUrl;
    private String url;
    private String type;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    @SerializedName("created_at")
    private ZonedDateTime createdAt;
}
