package fr.xebia.hotels.dataaccessservice;

import com.mongodb.Mongo;
import fr.xebia.hotels.dataaccessservice.model.Hotel;
import fr.xebia.hotels.dataaccessservice.model.Manager;
import fr.xebia.hotels.dataaccessservice.repository.HotelsRepository;
import fr.xebia.hotels.dataaccessservice.repository.ManagersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {
    @Autowired
    private HotelsRepository hotelsRepository;

    @Autowired
    private ManagersRepository managersRepository;

    @Autowired
    private
    MongoDbFactory mongoDbFactory;

    @Autowired
    private
    Mongo mongo;

    @Override
    public void run(String... args) throws Exception {
        mongo.dropDatabase(mongoDbFactory.getDb().getName());

        Manager eric = this.managersRepository.save(
                Manager.builder()
                        .age(12)
                        .name("Eric Cartman")
                        .description("A child who dreams about having a million dollars")
                        .build())
                .block();
        this.hotelsRepository.save(
                Hotel.builder()
                        .name("Bargain Hotel")
                        .city("Paris")
                        .countryCode("fr")
                        .description("At the heart of Paris, Nyah Nyah Nyah Nyah Nyah!")
                        .manager(eric)
                        .build())
                .block();
    }
}
