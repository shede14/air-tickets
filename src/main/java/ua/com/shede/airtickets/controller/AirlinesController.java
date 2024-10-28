package ua.com.shede.airtickets.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.shede.airtickets.entity.Airline;
import ua.com.shede.airtickets.service.AirlineService;

@RestController
@RequestMapping("/airlines")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AirlinesController {
    private final AirlineService airlineService;

    @GetMapping
    Flux<Airline> list(){
        return airlineService.list();
    }

    @PostMapping
    Mono<Airline> add(@RequestBody Airline airline){
        return airlineService.addOne(airline);
    }

    @PutMapping
    Mono<Airline> update(@RequestBody Airline airline){
        return  airlineService.update(airline);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable Long id){
        return airlineService.delete(id);
    }

}
