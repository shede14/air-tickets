package ua.com.shede.airtickets.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ua.com.shede.airtickets.entity.Role;

public interface RoleRepository extends ReactiveCrudRepository<Role, Long> {
    @Query("SELECT * FROM roles WHERE id = :id")
    Mono<Role> findById(Long id);
}
