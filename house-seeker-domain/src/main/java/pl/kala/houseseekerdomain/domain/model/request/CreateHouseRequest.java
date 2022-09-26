package pl.kala.houseseekerdomain.domain.model.request;

import io.vavr.collection.List;
import lombok.Builder;
import lombok.Value;
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.HeatingKind;
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.HouseKind;
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.HouseState;
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.Media;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
@Builder(toBuilder = true)
public class CreateHouseRequest {

    @NotNull
    String locality;

    @NotNull
    Double price;

    @NotNull
    Double squareMeters;

    List<Media> mediaList;

    @NotNull
    HouseKind houseKind;

    HouseState houseState;

    HeatingKind heatingKind;

    Integer floor;

    Boolean elevator;

    LocalDate buildDate;

    Boolean hasBalcony;

    Boolean hasBasement;
}
