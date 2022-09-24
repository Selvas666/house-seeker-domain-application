package pl.kala.houseseekerdomain.domain.model.request;

import lombok.Builder;
import lombok.Value;
import pl.kala.houseseekerdomain.domain.model.request.dto.CreateHouseDto;

@Value
@Builder(toBuilder = true)
public class CreateHouseRequest {

    CreateHouseDto createHouseDto;
}
