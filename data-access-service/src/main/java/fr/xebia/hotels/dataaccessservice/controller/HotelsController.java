package fr.xebia.hotels.dataaccessservice.controller;

import fr.xebia.hotels.dataaccessservice.repository.HotelsRepository;
import fr.xebia.hotels.dataaccessservice.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hotels")
public class HotelsController {
    @Autowired
    private HotelsRepository hotelsRepository;

    @PostMapping
    public Mono<Hotel> postHotel(@RequestBody final Hotel hotel) {
        return this.hotelsRepository.save(hotel);
    }

    @GetMapping
    public Flux<Hotel> getHotels() {
        return this.hotelsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Hotel> getHotel(@PathVariable final String id) {
        return this.hotelsRepository.findById(id);
    }

    @DeleteMapping
    public Flux<Hotel> deleteHotelByName(@RequestParam final String name) {
        return this.hotelsRepository.deleteByName(name);
    }
}
