package ua.com.shede.airtickets.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.shede.airtickets.entity.Customer;
import ua.com.shede.airtickets.entity.CustomerRegisterRequest;
import ua.com.shede.airtickets.repo.CustomerRepository;
import ua.com.shede.airtickets.repo.RoleRepository;
import ua.com.shede.airtickets.repo.RolesHasCustomersRepository;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class CustomerService implements ReactiveUserDetailsService {
    private final CustomerRepository customerRepository;

    private final RolesHasCustomersRepository rolesHasCustomersRepository;
    private final RoleRepository roleRepository;

    public Flux<GrantedAuthority> getAuthorities(Long customerId) {
        return rolesHasCustomersRepository.findRoleIdsByCustomerId(customerId)
                .flatMap(roleId -> roleRepository.findById(roleId))
                .map(role -> role).cast(GrantedAuthority.class);
    }

    public Flux<Customer> list() {
        return customerRepository.findAll();
    }

    public Mono<Customer> addOne(Customer customer) {
        return customerRepository.save(customer);
    }

    public Mono<Customer> update(Customer customer) {
        return  customerRepository.save(customer);
    }

    public Mono<Void> delete(Long id) {
        return customerRepository.deleteById(id);
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return customerRepository.findByUsername(username)
                .flatMap(user ->
                        getAuthorities(user.getId())
                                .collectList()
                                .map(authorities -> {
                                    user.setAuthorities(new HashSet<>(authorities));
                                    return user;
                                })
                );
    }

    public Mono<Customer> registerUser(CustomerRegisterRequest request) {
        return customerRepository.existsCustomerByEmail(request.email()).flatMap(exists -> {
            if (exists) {
                return Mono.error(new IllegalArgumentException("Email already in use"));
            } else {
                Customer newCustomer = Customer.builder()
                        .name(request.name())
                        .email(request.email())
                        .phone(request.phone())
                        .address(request.address())
                        .password(request.password())
                        .build();
                return customerRepository.save(newCustomer).flatMap(customer -> rolesHasCustomersRepository.addRole(customer.getId()).thenReturn(customer));
            }
        });
    }
}
