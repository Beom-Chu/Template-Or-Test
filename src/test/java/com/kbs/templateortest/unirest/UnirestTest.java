package com.kbs.templateortest.unirest;

import kong.unirest.HttpResponse;
import kong.unirest.HttpStatus;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnirestTest {

    private final String BASE_URL = "https://api.github.com/";
    private final String USER = "Beom-Chu";
    private final String GET_USER_REPOS = "users/{user}/repos";

    @Test
    public void TestUnirest(){

        HttpResponse<JsonNode> response = Unirest.get(BASE_URL + GET_USER_REPOS)
                .routeParam("user", USER)
                .asJson();

        System.out.println("[[[response.getStatus() = " + response.getStatus());
        System.out.println("[[[jsonNodeHttpResponse.getBody() = " + response.getBody());

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void TestUnirest2() {

        Unirest.config().defaultBaseUrl(BASE_URL);
        HttpResponse<JsonNode> response = Unirest.get(GET_USER_REPOS)
                .routeParam("user", USER)
                .asJson();

        System.out.println("[[[response.getStatus() = " + response.getStatus());
        System.out.println("[[[jsonNodeHttpResponse.getBody() = " + response.getBody());

        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK);
    }
}
