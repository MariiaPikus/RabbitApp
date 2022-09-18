package maria.pikus.producerrabbitmq;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;
@JsonPropertyOrder({ "serviceUUID", "message"})
@Component
public class SendingInfo {
    @Value("${send.massage}")
    private String message;
    private String serviceUUID;



    public SendingInfo() {
        this.serviceUUID= UUID.randomUUID().toString();

    }

    public String getMessage() {
        return message;
    }

    public String getServiceUUID() {
        return serviceUUID;
    }
}
