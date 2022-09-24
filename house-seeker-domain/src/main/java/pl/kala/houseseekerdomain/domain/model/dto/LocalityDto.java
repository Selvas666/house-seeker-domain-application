package pl.kala.houseseekerdomain.domain.model.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@Builder(toBuilder = true)
public class LocalityDto {

    @NotNull
    String name;

    String voivodeship;

    int distanceFromHome;

    int distanceFromRailStation;
}
