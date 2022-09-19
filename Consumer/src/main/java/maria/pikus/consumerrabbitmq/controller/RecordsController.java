package maria.pikus.consumerrabbitmq.controller;

import maria.pikus.consumerrabbitmq.entity.Record;
import maria.pikus.consumerrabbitmq.servise.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @DeleteMapping("/services/{service}")
    public void deleteService(@PathVariable(value = "service") String service){
        List<Record> records = messageService.findByService(service);
            messageService.delete(records);

    }


//    @GetMapping("/services/{service}")
//    public List<Record> gets(@PathVariable(value = "service") String service){
//        List<Record> records = messageService.findByService(service);
//       return records;
//    }
}
