package com.kbs.templateortest.rabbitmq.template.sender;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Exchange 와 Queue의 관계 설정
 *
 * Exchange	: Publisher(Producer)로부터 수신한 메시지를 큐에 분배하는 라우터 역할
 * Queue	: 메시지를 메모리나 디스크에 저장했다가 Cusomer에게 메시지를 전달하는 역할
 * Binding	: Exchange와 Queue의 관계를 정의한 것
 *
 * * 하나의 Exchange에서 여러개의 Queue로 분배 가능 (주석 부분)
 */
//@Configuration
@Getter
public class AmqpBindingConfig {

    public String exchangeName = "exchange-test-1";
    public String queueName1 = "queue-test-1";
    public String routingKey = "routingkey-1";


    @Bean
    public DirectExchange amqpExchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Queue amqpQueue1() {
        return new Queue(queueName1);
    }

    @Bean
    public Binding amqpBinding1(DirectExchange amqpExchange, Queue amqpQueue1) {
        return BindingBuilder.bind(amqpQueue1)
                .to(amqpExchange)
                .with(routingKey);
    }


    /*
    // Queue 추가 설정
    public String queueName2 = "queue-test-2";

    @Bean
    public Queue amqpQueue2() {
        return new Queue(queueName2);
    }

    @Bean
    public Binding amqpBinding(DirectExchange amqpExchange, Queue amqpQueue2) {
        return BindingBuilder.bind(amqpQueue2)
                .to(amqpExchange)
                .with(routingKey);
    }
    */
}
