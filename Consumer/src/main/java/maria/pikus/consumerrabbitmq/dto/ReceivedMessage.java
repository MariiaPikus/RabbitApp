package maria.pikus.consumerrabbitmq.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReceivedMessage {
    private String mess;
    private String address;
}
