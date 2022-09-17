package maria.pikus.producerrabbitmq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import maria.pikus.producerrabbitmq.Message;
import maria.pikus.producerrabbitmq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MessageController {

    @Autowired
    Sender sender;

    @RequestMapping("/send")
    public String sendMsg(@RequestParam("msg") String msg, HttpServletRequest request) throws JsonProcessingException {
        Message message = new Message(msg, request.getRemoteAddr());
        ObjectMapper mapper = new ObjectMapper();
        String messageJSON = mapper.writeValueAsString(message);
        sender.produceMsg(messageJSON);
        return messageJSON;
    }
}
