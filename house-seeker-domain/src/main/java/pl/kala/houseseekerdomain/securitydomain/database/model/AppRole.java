package pl.kala.houseseekerdomain.securitydomain.database.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(toBuilder = true)
@Document(collection = "roles")
public class AppRole {
}
