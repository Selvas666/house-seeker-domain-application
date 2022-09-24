package pl.kala.houseseekerdomain.domain.model.response.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder(toBuilder = true)
public class GetLocalityDto {

    @NotNull
    String name;

    String voivodeship;

    Double distanceFromHome;

    Double distanceFromRailStation;
}
