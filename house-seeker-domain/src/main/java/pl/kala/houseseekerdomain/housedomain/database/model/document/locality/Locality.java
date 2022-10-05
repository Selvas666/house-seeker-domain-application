package pl.kala.houseseekerdomain.housedomain.database.model.document.locality;

import com.mongodb.lang.NonNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import pl.kala.houseseekerdomain.housedomain.database.model.document.house.House;
import pl.kala.houseseekerdomain.housedomain.database.model.document.locality.enumeration.Voivodship;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
@Document(collection = "localities")
public class Locality {
    @Id
    String id;

    @NonNull
    private String name;

    @NonNull
    private LocalDateTime entryDate;

    @DocumentReference
    @ReadOnlyProperty
    private List<House> houses;

    private Voivodship voivodship;

    private Double distanceFromHome;

    private Double distanceFromRailStation;
}
