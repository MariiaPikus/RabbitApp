package com.example.messagingrabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void recievedMessage(String msg) {
        System.out.println("Received Message: " + msg);
    }

}
