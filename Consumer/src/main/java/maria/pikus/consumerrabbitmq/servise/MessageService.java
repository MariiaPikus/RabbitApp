package maria.pikus.consumerrabbitmq.servise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import maria.pikus.consumerrabbitmq.dto.ReceivedMessage;
import maria.pikus.consumerrabbitmq.entity.Record;
import maria.pikus.consumerrabbitmq.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MessageService {

    @Autowired
    MessageRepo messageRepo;

    public void saveRecord (String msg) throws JsonProcessingException {

        ReceivedMessage receivedMessage = new ObjectMapper().readValue(msg, ReceivedMessage.class);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);

        messageRepo.save(new Record(receivedMessage.getServiceUUID(), receivedMessage.getMessage(), formatDateTime));

    }

}
