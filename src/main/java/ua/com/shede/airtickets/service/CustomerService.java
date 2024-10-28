package ua.com.shede.airtickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.shede.airtickets.entity.Customer;
import ua.com.shede.airtickets.repo.CustomerRepository;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
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
}
