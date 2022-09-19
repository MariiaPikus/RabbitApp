package maria.pikus.consumerrabbitmq.controller;

import maria.pikus.consumerrabbitmq.servise.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecordsController {

    @Autowired
    MessageService messageService;

    @GetMapping("/services")
    public List<String> getServices() {
        return messageService.findRegisterServices();
    }

    @GetMapping("/services/active")
    public List<String> getActiveServices() {
        return messageService.findActiveServices();
    }
}
