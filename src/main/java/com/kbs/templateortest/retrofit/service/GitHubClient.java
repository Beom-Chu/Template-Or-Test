package com.kbs.templateortest.retrofit.service;

import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class GitHubClient {

    private final String baseUrl = "https://api.github.com";

    private Retrofit retrofit = null;

    private Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public GitHubService getService() {
        return getClient().create(GitHubService.class);
    }

}
