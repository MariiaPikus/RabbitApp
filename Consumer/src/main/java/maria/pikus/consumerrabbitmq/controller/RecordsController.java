package maria.pikus.consumerrabbitmq.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import maria.pikus.consumerrabbitmq.entity.Record;
import maria.pikus.consumerrabbitmq.servise.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "Контроллер для запроса информации о сервисах в сети")
@RequestMapping("/api")
public class RecordsController {

    @Autowired
    RecordsService recordsService;

    @GetMapping("/services")
    @ApiOperation("Получение списка всех зарегестрированных в сети сервисов")
    public List<String> getServices() {
        return recordsService.findRegisterServices();
    }

    @GetMapping("/services/active")
    @ApiOperation("Получение списка всех активных сервисов в сети")
    public List<String> getActiveServices() {
        return recordsService.findActiveServices();
    }

    @DeleteMapping("/services/{service}")
    @ApiOperation("Удаление из БД информации о конкретном сервисе")
    public void deleteService(@PathVariable(value = "service") String service) {
        List<Record> records = recordsService.findByService(service);
        recordsService.delete(records);
    }
}
