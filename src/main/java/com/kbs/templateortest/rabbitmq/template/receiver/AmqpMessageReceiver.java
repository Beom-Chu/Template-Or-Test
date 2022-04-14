package com.kbs.templateortest.rabbitmq.template.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AmqpMessageReceiver {

    @RabbitListener(queues = "queue-test-1")
    public void amqpReceiver(ReceiverDto dto) {
        System.out.println("[[[receiver = " + dto);
    }
}
