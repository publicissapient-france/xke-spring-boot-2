package fr.xebia.hotels.dataaccessservice.controller;

import fr.xebia.hotels.dataaccessservice.model.Manager;
import fr.xebia.hotels.dataaccessservice.repository.ManagersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/managers")
public class ManagersController {
    @Autowired
    private ManagersRepository managersRepository;

    @PostMapping
    public Mono<Manager> postManager(@RequestBody final Manager manager) {
        return this.managersRepository.save(manager);
    }

    @GetMapping
    public Flux<Manager> getManagers() {
        return this.managersRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Manager> getManager(@PathVariable final String id) {
        return this.managersRepository.findById(id);
    }
}
