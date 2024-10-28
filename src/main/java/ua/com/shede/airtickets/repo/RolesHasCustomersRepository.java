package ua.com.shede.airtickets.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.shede.airtickets.entity.Customer;
import ua.com.shede.airtickets.entity.RolesHasCustomers;

public interface RolesHasCustomersRepository extends ReactiveCrudRepository<RolesHasCustomers, Long> {
    @Query("SELECT role_id FROM roles_has_customers WHERE customer_id = :customerId")
    Flux<Long> findRoleIdsByCustomerId(Long customerId);

    @Query("INSERT INTO roles_has_customers(customer_id, role_id) VALUES (:customerId, 1)")
    Mono<Customer> addRole(Long customerId);
}
