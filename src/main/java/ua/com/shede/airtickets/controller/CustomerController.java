package ua.com.shede.airtickets.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.shede.airtickets.entity.Customer;
import ua.com.shede.airtickets.service.CustomerService;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    Flux<Customer> list(){
        return customerService.list();
    }

    @PostMapping
    Mono<Customer> add(@RequestBody Customer customer){
        return customerService.addOne(customer);
    }

    @PutMapping
    Mono<Customer> update(@RequestBody Customer customer){
        return  customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable Long id){
        return customerService.delete(id);
    }
}
