package maria.pikus.AdminClient.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(schema = "public", name = "messagesTest")
public class Message {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "mess_id")
    private Long id;

    private String message;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
