package com.kbs.templateortest.unirest;

import com.kbs.templateortest.githubapi.dto.User;
import com.kbs.templateortest.githubapi.dto.Repo;
import kong.unirest.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


// Unirest 사용법 : http://kong.github.io/unirest-java/
public class UnirestTest {

    private final String BASE_URL = "https://api.github.com/";
    private final String USER = "Beom-Chu";
    private final String GET_USER_REPOS = "users/{user}/repos";
    private final String GET_USER = "users/{user}";

    @Test
    @DisplayName("Unirest 샘플")
    public void testUnirest(){

        HttpResponse<JsonNode> response = Unirest.get(BASE_URL + GET_USER_REPOS)
                .routeParam("user", USER)
                .queryString("param1","test-param")
                .asJson();

        System.out.println("[[[response.getStatus() = " + response.getStatus());
        System.out.println("[[[jsonNodeHttpResponse.getBody() = " + response.getBody());

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("config 활용")
    public void testUnirestConfig() {
        Unirest.config().defaultBaseUrl(BASE_URL);
        HttpResponse<JsonNode> response = Unirest.get(GET_USER_REPOS)
                .routeParam("user", USER)
                .asJson();

        System.out.println("[[[response.getStatus() = " + response.getStatus());
        System.out.println("[[[jsonNodeHttpResponse.getBody() = " + response.getBody());

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("post 사용")
    public void testPost() {

        // post 는 queryString, field 둘 다 사용 가능
        HttpResponse<JsonNode> response = Unirest.post(BASE_URL)
                .queryString("param", "test_param")
                .field("param2", "test_param")
                .asJson();

        System.out.println("[[[response.getStatus() = " + response.getStatus());
    }

    @Test
    @DisplayName("Java객체로 반환")
    public void testResponseObject() {
        Unirest.config().defaultBaseUrl(BASE_URL);
        HttpResponse<User> response = Unirest.get(GET_USER)
                .routeParam("user", USER)
                .asObject(User.class);

        System.out.println("[[[response.getStatus() = " + response.getStatus());
        System.out.println("[[[response.getBody() = " + response.getBody());
    }


    @Test
    @DisplayName("List<객체>로 반환")
    public void testResponseObjectList(){

        HttpResponse<List<Repo>> response = Unirest.get(BASE_URL + GET_USER_REPOS)
                .routeParam("user", USER)
                .asObject(new GenericType<>(){});

        System.out.println("[[[response.getStatus() = " + response.getStatus());

        for(Repo repo : response.getBody()) {
            System.out.println("[[[repo = " + repo);
        }
    }
}
