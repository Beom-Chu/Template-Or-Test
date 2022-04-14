package com.kbs.templateortest.rabbitmq.template.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AmqpMessageSender {

    private final RabbitTemplate rabbitTemplate;
    private final AmqpBindingConfig bindingConfig;

    @Scheduled(fixedRate = 3000)
    public void sender() {

        SendDto dto = SendDto.builder().name("kbs")
                .id(UUID.randomUUID().toString())
                .time(LocalDateTime.now().toString()).build();

        System.out.println("[[[sender : dto = " + dto);

        rabbitTemplate.convertAndSend(bindingConfig.getExchangeName(), bindingConfig.getRoutingKey(), dto);
    }
}
