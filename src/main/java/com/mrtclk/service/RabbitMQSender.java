package com.mrtclk.service;

import com.mrtclk.model.Person;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitAmqpTemplate;

    @Value("${muratcelik.rabbitmq.exchange}")
    String exchange;

    @Value("${muratcelik.rabbitmq.routingkey}")
    String routingKey;

    public void send(Person company) {
        rabbitAmqpTemplate.convertAndSend(exchange, routingKey, company);
        System.out.println(("Send msg = " + company));
    }
}
