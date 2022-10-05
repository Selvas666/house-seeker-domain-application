package pl.kala.houseseekerdomain.housedomain.database.repository;

import io.vavr.control.Option;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.kala.houseseekerdomain.housedomain.database.model.document.locality.Locality;

public interface LocalityRepository extends MongoRepository<Locality, String> {
    Option<Locality> findLocalityByNameIgnoreCase(String name);
}
