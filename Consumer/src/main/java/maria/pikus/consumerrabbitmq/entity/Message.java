package maria.pikus.consumerrabbitmq.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(schema = "public", name = "messagesTest")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;
    private String address;

    public Message(String message, String address) {
        this.message = message;
        this.address = address;
    }
}
