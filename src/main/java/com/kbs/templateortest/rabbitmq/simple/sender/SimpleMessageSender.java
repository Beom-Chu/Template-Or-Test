package com.kbs.templateortest.rabbitmq.simple.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

//@Configuration
@RequiredArgsConstructor
public class SimpleMessageSender {

    private final RabbitTemplate rabbitTemplate;
    
//    @Scheduled(fixedRate = 3000)
    public void sender() {
        String time = LocalDateTime.now().toString();
        System.out.println("[[[sender : time = " + time);
        rabbitTemplate.convertAndSend("simple", "simple-r-key", time);
    }
}
