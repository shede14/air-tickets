package ua.com.shede.airtickets.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ua.com.shede.airtickets.entity.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
}
