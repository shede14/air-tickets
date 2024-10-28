package ua.com.shede.airtickets.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.shede.airtickets.entity.Flight;
import ua.com.shede.airtickets.service.FlightService;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class FlightController {
    private final FlightService flightService;

    @GetMapping
    Flux<Flight> list(){
        return flightService.list();
    }

    @PostMapping
    Mono<Flight> add(@RequestBody Flight flight){
        return flightService.addOne(flight);
    }

    @PutMapping
    Mono<Flight> update(@RequestBody Flight flight){
        return flightService.update(flight);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable Long id){
        return flightService.delete(id);
    }
}
