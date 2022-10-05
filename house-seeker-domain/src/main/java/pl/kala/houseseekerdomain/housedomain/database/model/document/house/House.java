package pl.kala.houseseekerdomain.housedomain.database.model.document.house;

import com.mongodb.lang.NonNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import pl.kala.houseseekerdomain.housedomain.database.model.document.house.enumeration.HeatingKind;
import pl.kala.houseseekerdomain.housedomain.database.model.document.house.enumeration.HouseKind;
import pl.kala.houseseekerdomain.housedomain.database.model.document.house.enumeration.HouseState;
import pl.kala.houseseekerdomain.housedomain.database.model.document.house.enumeration.Media;
import pl.kala.houseseekerdomain.housedomain.database.model.document.locality.Locality;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
@Document(collection = "houses")
public class House {
    @Id
    String id;

    @DocumentReference(lazy = true)
    @NonNull
    private Locality locality;

    @NonNull
    private Double price;

    @NonNull
    private Double squareMeters;

    @NonNull
    private HouseKind houseKind;

    @NonNull
    private Double pricePerSqMeter;

    @NonNull
    private LocalDateTime entryDate;

    private List<Media> mediaList;

    private HouseState houseState;

    private HeatingKind heatingKind;

    private Integer floor;

    private Boolean elevator;

    private LocalDate buildDate;

    private Boolean hasBalcony;

    private Boolean hasBasement;
}
