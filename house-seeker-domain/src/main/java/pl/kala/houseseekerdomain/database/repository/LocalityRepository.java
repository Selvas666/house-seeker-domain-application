package pl.kala.houseseekerdomain.database.repository;

import io.vavr.control.Option;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.kala.houseseekerdomain.database.model.document.locality.Locality;

public interface LocalityRepository extends MongoRepository<Locality, String> {
    Option<Locality> findLocalityByNameIgnoreCase(String name);
}
