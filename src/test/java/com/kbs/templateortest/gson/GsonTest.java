package com.kbs.templateortest.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

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
}
