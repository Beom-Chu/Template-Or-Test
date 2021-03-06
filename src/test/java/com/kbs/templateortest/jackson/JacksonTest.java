package com.kbs.templateortest.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

class JacksonTest {

    static ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    static void beforeAll() {
        mapper.registerModule(new JavaTimeModule()); // 날짜타입 변환을 위한 추가
    }

    @Test
    @DisplayName("Java Object => Json String")
    public void testObjectToJsonString() throws JsonProcessingException {

        Member member = Member.builder().id(1).name("kbs").email("kbs@test.com").gender(Gender.MAN)
                .age(10).phoneNumber("010-1234-5678").regDate(LocalDateTime.now()).build();

        String jsonString = mapper.writeValueAsString(member);

        System.out.println("[[[jsonString = " + jsonString);

        /* json 이쁘게 출력 */
        String jsonStringPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(member);
        System.out.println("[[[jsonStringPretty = " + jsonStringPretty);

    }

    @Test
    @DisplayName("Json String => Java Object")
    public void testJsonToObject() throws JsonProcessingException {

        String jsonString = "{\"id\":1,\"name\":\"kbs\",\"age\":10,\"email\":\"kbs@test.com\",\"gender\":\"MAN\",\"regDate\":[2022,5,11,16,3,35],\"phone-no\":\"010-1234-5678\"}";

        Member member = mapper.readValue(jsonString, Member.class);

        System.out.println("[[[member = " + member);
        System.out.println("[[[member.getGender().getName() = " + member.getGender().getName());
    }

    @Test
    @DisplayName("File => Java Object")
    public void testFileToObject() throws IOException {

        Path path = Paths.get(System.getProperty("user.dir"),"src","main","java","com","kbs","templateortest","jackson","data.json");
        File file = new File(String.valueOf(path));

        Member member = mapper.readValue(file, Member.class);

        System.out.println("[[[member = " + member);
        System.out.println("[[[member.getGender().getName() = " + member.getGender().getName());
    }

    @Test
    @DisplayName("Java Object => JsonNode")
    public void testObjectToJsonNode() throws JsonProcessingException {

        String jsonString = "{\"id\":1,\"name\":\"kbs\",\"age\":10,\"email\":\"kbs@test.com\",\"gender\":\"MAN\",\"regDate\":[2022,5,11,16,3,35],\"phone-no\":\"010-1234-5678\"}";

        JsonNode jsonNode = mapper.readTree(jsonString);

        System.out.println("[[[jsonNode = " + jsonNode);
    }

    @Test
    @DisplayName("Json String => Java List")
    public void testJsonStringToList() throws JsonProcessingException {
        String jsonString = "[{\"id\":1,\"name\":\"kbs\",\"age\":10,\"email\":\"kbs@test.com\",\"gender\":\"MAN\",\"regDate\":[2022,5,11,16,3,35],\"phone-no\":\"010-1234-5678\"}," +
                "{\"id\":2,\"name\":\"ljs\",\"age\":12,\"email\":\"ljs@test.com\",\"gender\":\"WOMAN\",\"regDate\":[2022,5,12,12,4,30],\"phone-no\":\"010-0000-0000\"}]";

        List<Member> members = mapper.readValue(jsonString, new TypeReference<List<Member>>(){});

        System.out.println("[[[members = " + members);
    }

    @Test
    @DisplayName("Json String => Map")
    public void testJsonStringToMap() throws JsonProcessingException {
        String jsonString = "{\"id\":1,\"name\":\"kbs\",\"age\":10,\"email\":\"kbs@test.com\",\"gender\":\"MAN\",\"regDate\":[2022,5,11,16,3,35],\"phone-no\":\"010-1234-5678\"}";

        Map<String, Object> stringObjectMap = mapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {});

        System.out.println("[[[stringObjectMap = " + stringObjectMap);
    }
}