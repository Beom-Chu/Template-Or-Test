package com.kbs.templateortest.gson;

import com.google.gson.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class GsonTest {

    @Test
    public void test() {

        String jsonString = "{\n" +
                "    \"campId\": \"M1800075\",\n" +
                "    \"prodId\": \"S0116326\"}";

        JsonObject jsonObject = (JsonObject) JsonParser.parseString(jsonString);
        String campId = jsonObject.get("campId").getAsString();
        String prodId = jsonObject.get("prodId").getAsString();
        String trId = jsonObject.get("trId").getAsString();

        System.out.println("[[[campId = " + campId);
        System.out.println("[[[prodId = " + prodId);
        System.out.println("[[[trId = " + trId);
    }

    @Test
    @DisplayName("registerTypeAdapter 사용 테스트")
    public void test2(){

        Gson gson = gson();

        LocalDate now = LocalDate.now();
        Instant instant = now.atStartOfDay(ZoneId.systemDefault()).toInstant();

        ObjLocalDate objLocalDate = new ObjLocalDate(1, Date.from(instant), now);

        System.out.println("[[[objLocalDate = " + objLocalDate);

        String gsonString = gson.toJson(objLocalDate);
        System.out.println("[[[gsonString = " + gsonString);

        ObjLocalDate objLocalDate2 = gson.fromJson(gsonString, ObjLocalDate.class);

        System.out.println("[[[objLocalDate2 = " + objLocalDate2);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ObjLocalDate {
        private int id;
        private Date date;
        private LocalDate localDate;
    }

    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateTypeConverter());
        gsonBuilder.registerTypeAdapter(Date.class, new DateTypeConverter());
        return gsonBuilder.create();
    }
}
