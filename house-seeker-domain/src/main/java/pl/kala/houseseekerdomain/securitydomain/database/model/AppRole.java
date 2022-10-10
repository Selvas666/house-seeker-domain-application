package pl.kala.houseseekerdomain.securitydomain.database.model;

import com.mongodb.lang.NonNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(toBuilder = true)
@Document(collection = "roles")
public class AppRole {
    @Id
    String id;

    @NonNull
    String name;
}
