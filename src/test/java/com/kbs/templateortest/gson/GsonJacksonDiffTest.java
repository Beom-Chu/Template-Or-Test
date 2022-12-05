package com.kbs.templateortest.gson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class GsonJacksonDiffTest {

    static ObjectMapper mapper = new ObjectMapper();

    static Gson gson = new Gson();

    @Test
    @DisplayName("Date타입 Jackson,Gson 직렬화/역직렬화 교차 테스트")
    public void test() throws JsonProcessingException {

        LocalDate now = LocalDate.now();
        Instant instant = now.atStartOfDay(ZoneId.systemDefault()).toInstant();

        ObjDate objDate = new ObjDate(1, Date.from(instant));

        System.out.println("[[[obj = " + objDate);


        String jackString = mapper.writeValueAsString(objDate);
        System.out.println("[[[jackString = " + jackString);

        String gsonString = gson.toJson(objDate);
        System.out.println("[[[gsonString = " + gsonString);


        ObjDate objJackToJack = mapper.readValue(jackString, ObjDate.class);
        System.out.println("[[[objJackToJack = " + objJackToJack);

        ObjDate objGsonToGson = gson.fromJson(gsonString, ObjDate.class);
        System.out.println("[[[objGsonToGson = " + objGsonToGson);


        ObjDate objGsonToJack = mapper.readValue(gsonString, ObjDate.class);
        System.out.println("[[[objGsonToJack = " + objGsonToJack);

        ObjDate objJackToGson = gson.fromJson(jackString, ObjDate.class);
        System.out.println("[[[objJackToGson = " + objJackToGson);


    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ObjDate {
        private int id;
        private Date date;
    }

    @Test
    @DisplayName("Gson Date타입 JsonString to Object 역직렬화 테스트")
    public void test2() {

        String str1 = "{\"id\":1,\"date\":\"Dec 5, 2022, 12:00:00 AM\"}";
        ObjDate objJackToGson1 = gson.fromJson(str1, ObjDate.class);
        System.out.println("[[[objJackToGson1 = " + objJackToGson1);

        String str2 = "{\"id\":1,\"date\":\"1961-08-10T15:00:00.000+00:00\"}";
        ObjDate objJackToGson2 = gson.fromJson(str2, ObjDate.class);
        System.out.println("[[[objJackToGson2 = " + objJackToGson2);

        String str3 = "{\"id\":1,\"date\":\"1961-08-10\"}";
        ObjDate objJackToGson3 = gson.fromJson(str3, ObjDate.class);
        System.out.println("[[[objJackToGson3 = " + objJackToGson3);
    }


}
