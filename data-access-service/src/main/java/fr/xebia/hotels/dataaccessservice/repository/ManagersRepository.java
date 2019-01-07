package fr.xebia.hotels.dataaccessservice.repository;

import fr.xebia.hotels.dataaccessservice.model.Manager;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagersRepository extends ReactiveCrudRepository<Manager, String> {
}
