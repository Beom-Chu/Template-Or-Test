package com.kbs.templateortest.rabbitmq.simple.receiver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class SimpleMessageReceiver {

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name = "simple", type = ExchangeTypes.TOPIC),
            value = @Queue(name = "simple-queue-name"),
            key = "simple-r-key"
    ))
    public void receiver(String msg) {
        System.out.println("[[[receiver : msg = " + msg);
    }
}
