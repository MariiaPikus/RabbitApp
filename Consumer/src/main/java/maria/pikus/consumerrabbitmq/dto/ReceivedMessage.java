package maria.pikus.consumerrabbitmq.dto;

import lombok.Data;

@Data
public class ReceivedMessage {
    private String serviceUUID;
    private String message;
}
