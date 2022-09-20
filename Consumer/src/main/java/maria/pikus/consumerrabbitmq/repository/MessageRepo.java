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

    @Query(value = "SELECT records.message_date FROM records WHERE records.id IN (SELECT MAX(records.id) FROM records GROUP BY records.service)", nativeQuery = true)
    List<String> findLastMessageTime();

    List<Record> findByService(String service);

    void delete(Record record);

}

//select message_date FROM records where id in (SELECT MAX(id) from records group by service) ;
