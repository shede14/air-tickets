package ua.com.shede.airtickets.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.shede.airtickets.entity.Flight;

public interface FlightRepository extends ReactiveCrudRepository<Flight, Long> {

}
