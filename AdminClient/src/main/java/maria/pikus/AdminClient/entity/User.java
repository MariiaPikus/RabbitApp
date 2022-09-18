package maria.pikus.AdminClient.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(schema = "public", name = "usrTest")
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "user_id")
    private Long id;

    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messages;

//    private String lastActiveDate;

}


