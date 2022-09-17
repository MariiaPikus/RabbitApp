package maria.pikus.AdminClient.repository;

import maria.pikus.AdminClient.entity.Message;
import maria.pikus.AdminClient.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
}

