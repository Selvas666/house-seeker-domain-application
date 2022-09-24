package pl.kala.houseseekerdomain.database.model.document.locality;

import com.mongodb.lang.NonNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.kala.houseseekerdomain.database.model.document.locality.enumeration.Voivodship;

@Data
@Builder(toBuilder = true)
@Document(collection = "localities")
public class Locality {
    @Id
    String id;

    @NonNull
    private String name;

    private Voivodship voivodship;

    private Double distanceFromHome;

    private Double distanceFromRailStation;
}
