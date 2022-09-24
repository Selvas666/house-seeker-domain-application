package pl.kala.houseseekerdomain.domain.mapping.response;

import io.vavr.collection.List;
import pl.kala.houseseekerdomain.domain.mapping.Mapper;
import pl.kala.houseseekerdomain.domain.model.response.GetAllHousesResponse;
import pl.kala.houseseekerdomain.domain.model.response.dto.GetHouseDto;

public class GetAllHousesMapper implements Mapper<List<GetHouseDto>, GetAllHousesResponse> {
//TODO: PAGINATION
    @Override
    public GetAllHousesResponse convert(List<GetHouseDto> source) {
        return GetAllHousesResponse.builder()
                .houses(source)
                .totalElements(source.length())
                .build();
    }

}
