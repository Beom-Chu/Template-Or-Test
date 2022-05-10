package com.kbs.templateortest.githubapi.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repo {
    private Long id;
    private String name;
    @SerializedName("node_id")
    private String nodeId;
    @SerializedName("full_name")
    private String fullName;
    private String url;
    private Long size;
    private Boolean visibility;
    private Owner owner;
}
