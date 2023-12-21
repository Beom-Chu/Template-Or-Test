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
import java.util.*;

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

    @Test
    public void testInnerClassSerialize() {
        GsonTestDto.GsonTestInnerDto inDto = new GsonTestDto.GsonTestInnerDto("inDtoName");
        GsonTestDto dto = new GsonTestDto("dtoName", inDto);
        System.out.println("[[[dto = " + dto);

        String toJson = new Gson().toJson(dto);
        System.out.println("[[[toJson = " + toJson);
    }

    @Test
    public void testMapListMapAndPrettyPrinting() {
        Map<String, List<Map<String, String>>> mlm = new HashMap<>();
        List<Map<String, String>> inList1 = new ArrayList<>();
        List<Map<String, String>> inList2 = new ArrayList<>();
        Map<String, String> inMap1 = new HashMap<>();
        Map<String, String> inMap2 = new HashMap<>();
        Map<String, String> inMap3 = new HashMap<>();

        inMap1.put("aaa","111");
        inMap1.put("bbb","222");
        inMap2.put("ccc","333");
        inMap2.put("ddd","444");
        inMap3.put("eee","555");
        inList1.add(inMap1);
        inList1.add(inMap2);
        inList2.add(inMap3);
        mlm.put("first",inList1);
        mlm.put("seconds",inList2);

        System.out.println("[[[mlm = " + mlm);
        System.out.println("[[[toJson = " + new Gson().toJson(mlm));

        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("[[[prettyGson.toJson(mlm) = " + prettyGson.toJson(mlm));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ObjLocalDate {
        private int id;
        private Date date;
        private LocalDate localDate;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class GsonTestDto {
        private String name;
        private GsonTestInnerDto gsonTestInnerDto;
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        static class GsonTestInnerDto {
            private String name;
        }
    }

    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateTypeConverter());
        gsonBuilder.registerTypeAdapter(Date.class, new DateTypeConverter());
        return gsonBuilder.create();
    }
}
