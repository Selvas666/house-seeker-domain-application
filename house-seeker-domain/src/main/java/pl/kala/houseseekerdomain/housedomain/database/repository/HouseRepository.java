package pl.kala.houseseekerdomain.housedomain.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.kala.houseseekerdomain.housedomain.database.model.document.house.House;

public interface HouseRepository extends MongoRepository<House, String> {
}
