package maria.pikus.consumerrabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import maria.pikus.consumerrabbitmq.dto.ReceivedMessage;
import maria.pikus.consumerrabbitmq.entity.Message;
import maria.pikus.consumerrabbitmq.service.MessageService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Receiver {

    @Autowired
    MessageService messService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveMessage(String msg) throws JsonProcessingException {
        log.info("Received Message: " + msg);
        messService.saveMess(msg);
    }

}
