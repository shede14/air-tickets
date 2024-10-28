package ua.com.shede.airtickets.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.shede.airtickets.entity.Airline;

public interface AirlineRepository extends ReactiveCrudRepository<Airline, Long> {

}
