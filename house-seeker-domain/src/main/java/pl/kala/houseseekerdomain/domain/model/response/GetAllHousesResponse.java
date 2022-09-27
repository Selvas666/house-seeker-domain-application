package pl.kala.houseseekerdomain.domain.model.response;

import lombok.Builder;
import lombok.Value;
import pl.kala.houseseekerdomain.domain.model.response.dto.GetHouseDto;

import java.util.List;

@Value
@Builder(toBuilder = true)
public class GetAllHousesResponse {

    long totalElements;

    List<GetHouseDto> houses;
}
