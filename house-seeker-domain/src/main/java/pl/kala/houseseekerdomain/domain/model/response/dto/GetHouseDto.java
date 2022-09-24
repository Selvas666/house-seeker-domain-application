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
    int price;

    @NotNull
    int squareMeters;

    List<String> mediaList;

    @NotNull
    String houseKind;

    String houseState;

    String heatingKind;

    int floor;

    boolean elevator;

    LocalDate buildDate;

    @NotNull
    double pricePerSqMeter;

    boolean hasBalcony;

    boolean hasBasement;

}
