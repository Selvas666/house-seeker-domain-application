package pl.kala.houseseekerdomain.securitydomain.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.kala.houseseekerdomain.securitydomain.database.model.AppRole;

public interface AppRoleRepository extends MongoRepository <AppRole, String> {
}
