package pl.kala.houseseekerdomain.domain.model.response.dto;

import io.vavr.collection.List;
import lombok.Builder;
import lombok.Value;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
@Builder(toBuilder = true)
public class GetHouseDto {

    @NotNull
    String id;

    @NotNull
    GetLocalityDto locality;

    @NotNull
    Double price;

    @NotNull
    Double squareMeters;

    @NotNull
    Double pricePerSqMeter;

    List<String> mediaList;

    @NotNull
    String houseKind;

    String houseState;

    String heatingKind;

    Integer floor;

    Boolean elevator;

    LocalDate buildDate;

    Boolean hasBalcony;

    Boolean hasBasement;

}
