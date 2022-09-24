package pl.kala.houseseekerdomain.domain.model.response;

import io.vavr.collection.List;
import lombok.Builder;
import lombok.Value;
import pl.kala.houseseekerdomain.domain.model.response.dto.GetHouseDto;

@Value
@Builder(toBuilder = true)
public class GetAllHousesResponse {

    long totalElements;

    List<GetHouseDto> houses;
}
