package pl.kala.houseseekerdomain.securitydomain.database.model;

import com.mongodb.lang.NonNull;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Builder(toBuilder = true)
@Document(collection = "users")
public class AppUser {

    @Id
    String id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    @DocumentReference
    List<AppRole> roles;
}
