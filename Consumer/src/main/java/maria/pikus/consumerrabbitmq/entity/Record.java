package maria.pikus.consumerrabbitmq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Record {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    private long id;

    private String serviceUUID;
    private String message;
    private String lastActiveDate;

    public Record(String serviceUUID, String message, String lastActiveDate) {
        this.serviceUUID = serviceUUID;
        this.message = message;
        this.lastActiveDate = lastActiveDate;
    }
}
