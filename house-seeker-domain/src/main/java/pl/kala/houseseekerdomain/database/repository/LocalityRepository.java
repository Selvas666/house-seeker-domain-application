package pl.kala.houseseekerdomain.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import pl.kala.houseseekerdomain.database.model.document.locality.Locality;

public interface LocalityRepository extends MongoRepository<Locality, String> {
    @Query("{name: '?0'}")
    Locality findLoaclityByName(String name);

    @Query("{id: '?0'}")
    Locality findLoaclityById(String id);
}
