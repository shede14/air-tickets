package ua.com.shede.airtickets.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.shede.airtickets.entity.Customer;
import ua.com.shede.airtickets.entity.Greeting;

@Component
public class GreetingHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Spring")));
    }

    public Mono<ServerResponse> users(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("User Page"));
    }

    public Mono<ServerResponse> admin(ServerRequest request) {

        Flux<Customer> users = Flux.
                just(
                        new Customer(1L, "Vasya", "1234@email.com", "+000000000", "adress1", "password1234"),
                        new Customer(1L, "Inna", "2345@email.com", "+111111111", "adress2", "password2345"),
                        new Customer(1L, "Zhana", "3456@email.com", "+222222222", "adress3", "password3456")
                );

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(users, Customer.class);
    }
}
