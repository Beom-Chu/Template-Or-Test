package com.kbs.templateortest.kafka.sender;

import com.kbs.templateortest.kafka.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class KafkaSender {

    @Value("${kafka.topic.str}")
    private String TOPIC_NAME_STR;

    @Value("${kafka.topic.usr}")
    private String TOPIC_NAME_USR;

    final private KafkaTemplate<Object, Object> kafkaTemplate;

    public void sender(String str) {

        kafkaTemplate.send(TOPIC_NAME_STR, str);
    }

    public void senderKey(String str) {
        String key = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
        kafkaTemplate.send(TOPIC_NAME_STR, key, str);
    }

    public void sender(UserDto dto) {

        kafkaTemplate.send(TOPIC_NAME_USR, dto);
    }

    public void senderKey(UserDto dto) {
        String key = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
        kafkaTemplate.send(TOPIC_NAME_USR, key, dto);
    }
}
