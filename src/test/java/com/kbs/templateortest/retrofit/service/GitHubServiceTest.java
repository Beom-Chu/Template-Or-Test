package com.kbs.templateortest.retrofit.service;



import com.kbs.templateortest.retrofit.dto.Repo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

class GitHubServiceTest {

    private final String BASE_URL = "https://api.github.com/";
    private final String USER = "Beom-Chu";

    private final GitHubClient gitHubClient = new GitHubClient();


    @Test
    @DisplayName("동기 실행")
    public void testSync() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //`Retrofit` 클래스로 `GitHubService` 인터페이스를 구현하여 생성
        GitHubService service = retrofit.create(GitHubService.class);

        Response<List<Repo>> response = null;
        try {
            response = service.listRepos(USER).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("response.isSuccessful() = " + response.isSuccessful());

        List<Repo> body = response.body();

        for (Repo repo : response.body()) {
            System.out.println("repo = " + repo);
        }
    }

    @Test
    @DisplayName("비동기 실행")
    public void testAsync() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //`Retrofit` 클래스로 `GitHubService` 인터페이스를 구현하여 생성
        GitHubService service = retrofit.create(GitHubService.class);

        service.listRepos(USER).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                System.out.println("response.isSuccessful = " + response.isSuccessful());
                List<Repo> list = response.body();
                for (Repo repo : list) {
                    System.out.println("repo = " + repo);
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                System.out.println("t.getMessage() = " + t.getMessage());
            }
        });

        System.out.println("service 호출 완료!");

        try {
            // 서비스 완료 로그를 보기 위한 sleep
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrofit으로 만들어진 Service를 반환하는 Client를 사용
     */
    @Test
    @DisplayName("Client 사용")
    public void testClient() {

        GitHubService service = gitHubClient.getService();

        Response<List<Repo>> response = null;
        try {
            response = service.listRepos(USER).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Repo> repos = response.body();

        for (Repo repo : repos) {
            System.out.println("repo = " + repo);
        }
    }
}