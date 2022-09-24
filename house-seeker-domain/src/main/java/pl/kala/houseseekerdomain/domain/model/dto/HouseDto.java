package pl.kala.houseseekerdomain.domain.model.dto;

import io.vavr.collection.List;
import lombok.Builder;
import lombok.Value;
import pl.kala.houseseekerdomain.domain.model.dto.enumeration.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
@Builder(toBuilder = true)
public class HouseDto {

    String id;

    @NotNull LocalityDto locality;

    @NotNull int price;

    @NotNull int squareMeters;

    List<Media> mediaList;

    @NotNull HouseKind houseKind;

    HouseState houseState;

    HeatingKind heatingKind;

    int floor;

    boolean elevator;

    LocalDate buildDate;

    @NotNull float pricePerSqMeter;

    boolean hasBalcony;

    boolean hasBasement;

}
