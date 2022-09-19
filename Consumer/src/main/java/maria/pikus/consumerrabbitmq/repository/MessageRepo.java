package maria.pikus.consumerrabbitmq.repository;

import maria.pikus.consumerrabbitmq.entity.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends CrudRepository<Record, Long> {

    @Query(value = "SELECT DISTINCT records.service FROM records", nativeQuery = true)
    List<String> findDistinctServicedNames();

    @Query(value = "SELECT DISTINCT * FROM records", nativeQuery = true)
    List<Record> findDistinctServices();

    List<Record> findByService(String service);

    void delete(Record record);

}
