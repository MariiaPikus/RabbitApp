package maria.pikus.consumerrabbitmq.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(schema = "public", name = "records")
public class Record {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    private long id;

    @Column(name = "service")
    private String service;
    @Column(name = "message_date")
    private String timeAndDate;

    public Record(String service, String timeAndDate) {
        this.service = service;
        this.timeAndDate = timeAndDate;
    }
}
