package maria.pikus.consumerrabbitmq.repository;

import maria.pikus.consumerrabbitmq.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<Record, Long> {
}
