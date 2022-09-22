package maria.pikus.producerrabbitmq;

import org.springframework.stereotype.Component;

import java.util.UUID;

//@JsonPropertyOrder({ "serviceUUID", "message"})
@Component
public class SendingInfo {
    private String service;

    public SendingInfo() {
        this.service = UUID.randomUUID().toString();

    }

    public String getService() {
        return service;
    }
}
