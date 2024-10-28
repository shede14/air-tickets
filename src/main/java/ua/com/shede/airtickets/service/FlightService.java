package ua.com.shede.airtickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.shede.airtickets.entity.Flight;
import ua.com.shede.airtickets.repo.FlightRepository;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    public Flux<Flight> list() {
        return flightRepository.findAll();
    }

    public Mono<Flight> addOne(Flight flight) {
        return flightRepository.save(flight);
    }

    public Mono<Flight> update(Flight flight) {
        return  flightRepository.save(flight);
    }

    public Mono<Void> delete(Long id) {
        return flightRepository.deleteById(id);
    }
}
