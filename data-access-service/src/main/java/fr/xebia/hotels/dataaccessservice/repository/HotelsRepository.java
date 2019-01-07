package fr.xebia.hotels.dataaccessservice.repository;

import fr.xebia.hotels.dataaccessservice.model.Hotel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface HotelsRepository extends ReactiveCrudRepository<Hotel, String> {
    Flux<Hotel> deleteByName(String name);
}