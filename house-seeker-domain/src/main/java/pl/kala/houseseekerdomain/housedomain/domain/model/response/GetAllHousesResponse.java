package pl.kala.houseseekerdomain.housedomain.domain.model.response;

import lombok.Builder;
import lombok.Value;
import pl.kala.houseseekerdomain.housedomain.domain.model.response.dto.GetHouseDto;

import javax.validation.constraints.NotNull;
import java.util.List;

@Value
@Builder(toBuilder = true)
public class GetAllHousesResponse {

    List<GetHouseDto> houses;

    @NotNull
    long pageNumber;

    @NotNull
    long totalPages;

    @NotNull
    long pageSize;

    @NotNull
    long totalElements;
}
