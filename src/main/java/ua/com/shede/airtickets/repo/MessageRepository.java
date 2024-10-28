package ua.com.shede.airtickets.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.shede.airtickets.entity.Message;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {

}
