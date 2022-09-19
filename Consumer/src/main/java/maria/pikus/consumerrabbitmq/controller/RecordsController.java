package maria.pikus.consumerrabbitmq.controller;

import maria.pikus.consumerrabbitmq.entity.Record;
import maria.pikus.consumerrabbitmq.servise.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecordsController {

    @Autowired
    RecordsService recordsService;

    @GetMapping("/services")
    public List<String> getServices() {
        return recordsService.findRegisterServices();
    }

    @GetMapping("/services/active")
    public List<String> getActiveServices() {
        return recordsService.findActiveServices();
    }

    @DeleteMapping("/services/{service}")
    public void deleteService(@PathVariable(value = "service") String service) {
        List<Record> records = recordsService.findByService(service);
        recordsService.delete(records);
    }

}
