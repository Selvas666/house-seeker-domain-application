package pl.kala.houseseekerdomain.database.model.document.house;

import com.mongodb.lang.NonNull;
import io.vavr.collection.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.HeatingKind;
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.HouseKind;
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.HouseState;
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.Media;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@Document(collection = "houses")
public class House {
    @Id
    String id;

    @NonNull
    private String localityId;

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
