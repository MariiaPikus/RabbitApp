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
    private String message;
    @Column(name = "last_active_date")
    private String timeAndDate;

    public Record(String service, String message, String timeAndDate) {
        this.service = service;
        this.message = message;
        this.timeAndDate = timeAndDate;
    }
}
