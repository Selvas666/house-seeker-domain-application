package pl.kala.houseseekerdomain.domain.model.dto;

import com.mongodb.lang.NonNull;
import lombok.Builder;
import lombok.Value;
import pl.kala.houseseekerdomain.domain.model.dto.enumeration.Voivodship;

import javax.validation.constraints.NotNull;

@Value
@Builder(toBuilder = true)
public class LocalityDto {

    @NotNull
    String id;

    @NotNull
    String name;

    Voivodship voivodship;

    int distanceFromHome;

    int distanceFromRailStation;
}
