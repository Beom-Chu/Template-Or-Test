package com.kbs.templateortest.kafka.sender;

import com.kbs.templateortest.kafka.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;

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

    /**
     * KafkaTemplate를 사용하여 send 메시지를 동기적으로 전송하는 방법.
     * KafkaTemplate의 send 메서드에 get() 메서드를 호출.
     * get() 메서드는 Future 인터페이스를 구현하는 ListenableFuture 타입의 객체를 반환하며,
     * 이 객체는 Kafka Producer가 메시지를 전송한 결과를 반환.
     * 따라서 get() 메서드를 호출하면 Kafka Producer가 메시지를 전송한 결과를 기다릴 수 있음.
     */
    public void syncSender(String str) throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult<Object, Object>> future = kafkaTemplate.send(TOPIC_NAME_STR, str);
        SendResult<Object, Object> result = future.get();
        RecordMetadata recordMetadata = result.getRecordMetadata();

        System.out.println("[[[recordMetadata.topic = "         + recordMetadata.topic());
        System.out.println("[[[recordMetadata.partition = "     + recordMetadata.partition());
        System.out.println("[[[recordMetadata.offset = "        + recordMetadata.offset());
        System.out.println("[[[recordMetadata.hasOffset = "     + recordMetadata.hasOffset());
        System.out.println("[[[recordMetadata.timestamp = "     + recordMetadata.timestamp());
        System.out.println("[[[recordMetadata.hasTimestamp = "  + recordMetadata.hasTimestamp());

    }
}
