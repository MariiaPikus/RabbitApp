package maria.pikus.consumerrabbitmq.repository;

import maria.pikus.consumerrabbitmq.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
