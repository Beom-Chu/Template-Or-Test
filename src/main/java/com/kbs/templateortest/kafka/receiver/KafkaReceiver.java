package com.kbs.templateortest.kafka.receiver;

import com.kbs.templateortest.kafka.dto.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiver {

    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter();
    }

    @KafkaListener(id = "testStringConsumer", topics = "${kafka.topic.str}")
    public void receiverString(String str) {
        System.out.println("[[[start KafkaReceiver.receiverString!!");
        System.out.println("[[[str = " + str);
    }

    @KafkaListener(id = "testUserConsumer", topics = "${kafka.topic.usr}")
    public void receiverUser(UserDto dto) {
        System.out.println("[[[start KafkaReceiver.receiverUser!!");
        System.out.println("[[[dto = " + dto);
    }

}
