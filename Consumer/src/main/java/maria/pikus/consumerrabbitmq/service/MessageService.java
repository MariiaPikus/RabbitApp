package maria.pikus.consumerrabbitmq.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import maria.pikus.consumerrabbitmq.dto.ReceivedMessage;
import maria.pikus.consumerrabbitmq.entity.Message;
import maria.pikus.consumerrabbitmq.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    MessageRepo messRepo;

    public void saveMess(String msg) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ReceivedMessage receivedMessage = objectMapper.readValue(msg, ReceivedMessage.class);
        Message message = new Message(receivedMessage.getMess(), receivedMessage.getAddress());
        messRepo.save(message);
    }

}
