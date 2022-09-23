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

@Data
@Builder(toBuilder = true)
@Document(collection = "houses")
public class House {
    @Id
    String id;

    @NonNull
    private String localityId;

    @NonNull
    private int price;

    @NonNull
    private int squareMeters;

    private List<Media> mediaList;

    @NonNull
    private HouseKind houseKind;

    private HouseState houseState;

    private HeatingKind heatingKind;

    private int floor;

    private boolean elevator;

    private LocalDate buildDate;

    @NonNull
    private float pricePerSqMeter;

    private boolean hasBalcony;

    private boolean hasBasement;


}
