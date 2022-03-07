package com.kbs.templateortest.retrofit.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    private String login;
    private Long id;
    @SerializedName("avatar_url")
    private String avatarUrl;
    private String url;
    @SerializedName("html_url")
    private String htmlUrl;
    private String type;
}
