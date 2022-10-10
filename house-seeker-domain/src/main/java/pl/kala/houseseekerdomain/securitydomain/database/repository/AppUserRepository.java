package pl.kala.houseseekerdomain.securitydomain.database.repository;

import io.vavr.control.Option;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.kala.houseseekerdomain.securitydomain.database.model.AppUser;

public interface AppUserRepository extends MongoRepository <AppUser, String> {
    Option<AppUser> findAppUserByUsernameIgnoreCase (String username);
}
