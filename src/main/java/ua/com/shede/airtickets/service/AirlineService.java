package ua.com.shede.airtickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.shede.airtickets.entity.Airline;
import ua.com.shede.airtickets.repo.AirlineRepository;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository){
        this.airlineRepository = airlineRepository;
    }

    public Flux<Airline> list() {
        return airlineRepository.findAll();
    }

    public Mono<Airline> addOne(Airline airline) {
        return airlineRepository.save(airline);
    }

    public Mono<Airline> update(Airline airline) {
        return  airlineRepository.save(airline);
    }

    public Mono<Void> delete(Long id) {
        return airlineRepository.deleteById(id);
    }

}
