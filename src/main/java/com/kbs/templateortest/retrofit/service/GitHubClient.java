package com.kbs.templateortest.retrofit.service;

import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

@Component
public class GitHubClient {

    private final String baseUrl = "https://api.github.com";

    private Retrofit retrofit = null;

    private Retrofit getClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES) // 연결 타임아웃(default : 10초)
                .readTimeout(30, TimeUnit.SECONDS) // 읽기 타임아웃(default : 10초)
                .writeTimeout(15, TimeUnit.SECONDS) // 쓰기 타임아웃(default : 10초)
                .build();


        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public GitHubService getService() {
        return getClient().create(GitHubService.class);
    }

}
