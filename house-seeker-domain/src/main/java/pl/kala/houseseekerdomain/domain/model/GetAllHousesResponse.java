package pl.kala.houseseekerdomain.domain.model;

import io.vavr.collection.List;
import lombok.Builder;
import lombok.Value;
import pl.kala.houseseekerdomain.domain.model.dto.GetAllHousesDto;

@Value
@Builder(toBuilder = true)
public class GetAllHousesResponse {

    long totalElements;

    List<GetAllHousesDto> houses;
}
