package pl.kala.houseseekerdomain.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.kala.houseseekerdomain.database.model.document.house.House;

public interface HouseRepository extends MongoRepository<House, String> {
}
