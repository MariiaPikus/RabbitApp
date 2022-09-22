package maria.pikus.producerrabbitmq;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    Sender sender;

    @Autowired
    SendingInfo sendingInfo;

    @Scheduled(fixedDelayString = "${time.rate}")
    public void reportInfo() throws JsonProcessingException {
        String msg = new ObjectMapper().writeValueAsString(sendingInfo);
        sender.produceMsg(msg);
    }
}