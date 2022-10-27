package com.kbs.templateortest.kafka;

import com.kbs.templateortest.kafka.dto.UserDto;
import com.kbs.templateortest.kafka.sender.KafkaSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class KafkaSenderTest {

    @Autowired
    private KafkaSender kafkaSender;

    @Test
    public void testString() {

        String str = "hello!!";
        kafkaSender.sender(str);
    }

    @Test
    public void testStringKey() {

        String str = "hello!!";
        kafkaSender.senderKey(str);
    }

    @Test
    public void testObject() {

        UserDto dto = new UserDto(1, "kbs", 36, LocalDateTime.now());
        kafkaSender.sender(dto);
    }

    @Test
    public void testObjectKey() {

        UserDto dto = new UserDto(1, "kbs", 36, LocalDateTime.now());
        kafkaSender.senderKey(dto);
    }
}
