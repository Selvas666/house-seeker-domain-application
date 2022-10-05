package pl.kala.houseseekerdomain.securitydomain.database.model;

import com.mongodb.lang.NonNull;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder(toBuilder = true)
@Document(collection = "users")
public class AppUser {

    @Id
    String email;

    @NonNull
    private String password;

    @NonNull
    private String username;

    @NonNull
    List<AppRole> roles;
}
