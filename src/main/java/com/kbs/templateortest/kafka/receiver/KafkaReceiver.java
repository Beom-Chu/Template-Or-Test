package com.kbs.templateortest.kafka.receiver;

import com.kbs.templateortest.kafka.dto.ConstructorTestDto;
import com.kbs.templateortest.kafka.dto.UserDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiver {

//    @KafkaListener(id = "testStringConsumer", topics = "${kafka.topic.str}")
    public void receiverString(String str) {
        System.out.println("[[[start KafkaReceiver.receiverString!!");
        System.out.println("[[[str = " + str);
    }

//    @KafkaListener(id = "testUserConsumer", topics = "${kafka.topic.usr}")
    public void receiverUser(UserDto dto) {
        System.out.println("[[[start KafkaReceiver.receiverUser!!");
        System.out.println("[[[dto = " + dto);
    }

    // 메시지 객체에 생성자만 존재시 에러 발생 재현
//    @KafkaListener(id = "testConstructorDto", topics = "${kafka.topic.constructorTest}")
    public void receiverConstructorDtoTest(ConstructorTestDto dto) {

        System.out.println("[[[dto = " + dto);
    }
}
