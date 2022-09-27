package pl.kala.houseseekerdomain.domain.model.response.dto;


import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

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

    @NotNull
    String houseKind;

    List<String> mediaList;

    String houseState;

    String heatingKind;

    Integer floor;

    Boolean elevator;

    LocalDate buildDate;

    Boolean hasBalcony;

    Boolean hasBasement;

}
