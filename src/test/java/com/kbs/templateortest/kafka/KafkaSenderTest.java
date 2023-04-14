package com.kbs.templateortest.kafka;

import com.kbs.templateortest.kafka.config.KafkaConfig;
import com.kbs.templateortest.kafka.dto.UserDto;
import com.kbs.templateortest.kafka.sender.KafkaSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

@SpringBootTest
public class KafkaSenderTest {

    @Autowired
    private KafkaSender kafkaSender;

    @Test
    public void testString() {

        String str = "hello!!" + Math.random();
        kafkaSender.sender(str);
    }

    @Test
    public void testStringKey() {

        String str = "hello!!" + Math.random();
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

        UserDto dto2 = new UserDto(1, "kbs", 36, LocalDateTime.now());
        kafkaSender.senderKey(dto2);
    }

    @Test
    public void testSyncSend() throws ExecutionException, InterruptedException {
        String str = "kafka!!" + Math.random();
        kafkaSender.syncSender(str);
    }
}
