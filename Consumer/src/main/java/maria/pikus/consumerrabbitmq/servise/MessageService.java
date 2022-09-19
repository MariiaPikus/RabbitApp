package maria.pikus.consumerrabbitmq.servise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import maria.pikus.consumerrabbitmq.dto.ReceivedMessage;
import maria.pikus.consumerrabbitmq.entity.Record;
import maria.pikus.consumerrabbitmq.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepo messageRepo;

    @Value("#{new Long('${time.active}')}")
    Long timeServiceActive;


    public void saveRecord (String msg) throws JsonProcessingException {
        ReceivedMessage receivedMessage = new ObjectMapper().readValue(msg, ReceivedMessage.class);
        String currentDataAndTime = LocalDateTime.now().toString();
        messageRepo.save(new Record(receivedMessage.getService(), currentDataAndTime));
    }

    public List<String> findRegisterServices(){
        return messageRepo.findDistinctServicedNames();
    }

    public List<String> findActiveServices(){
        List<String> result = new ArrayList<>();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime forActiveTime = now.minusNanos(timeServiceActive);
        List<Record> allServices = messageRepo.findDistinctServices();

        for (Record record : allServices) {
            LocalDateTime lastActiveTime = LocalDateTime.parse(record.getTimeAndDate());
            boolean isBefore = lastActiveTime.isBefore(forActiveTime);
            if(isBefore){
                result.add(record.getService());
            }
        }

        return result;
    }

    public List<Record> findByService(String service){
        return messageRepo.findByService(service);
    }

    public void delete(List<Record> records){
        for (Record record: records) {
            messageRepo.delete(record);
        }
    }

}
