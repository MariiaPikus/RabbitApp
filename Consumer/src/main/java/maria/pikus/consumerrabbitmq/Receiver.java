package maria.pikus.consumerrabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void recievedMessage(String msg) {
        System.out.println("Received Message: " + msg);
    }

}
