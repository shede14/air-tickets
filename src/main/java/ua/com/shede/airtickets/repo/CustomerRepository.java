package ua.com.shede.airtickets.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ua.com.shede.airtickets.entity.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {
    @Query("SELECT id, email, password FROM customers WHERE email = :username")
    Mono<Customer> findByUsername(String username);

    Mono<Boolean> existsCustomerByEmail(String email);
}
