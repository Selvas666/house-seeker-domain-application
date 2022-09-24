package pl.kala.houseseekerdomain.domain.model.request.dto;

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
public class CreateHouseDto {

    @NotNull
    String locality;

    @NotNull
    int price;

    @NotNull
    int squareMeters;

    List<Media> mediaList;

    @NotNull
    HouseKind houseKind;

    HouseState houseState;

    HeatingKind heatingKind;

    int floor;

    boolean elevator;

    LocalDate buildDate;

    boolean hasBalcony;

    boolean hasBasement;
}
