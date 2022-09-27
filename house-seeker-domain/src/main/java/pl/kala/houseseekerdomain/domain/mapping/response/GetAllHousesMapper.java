package pl.kala.houseseekerdomain.domain.mapping.response;


import pl.kala.houseseekerdomain.domain.mapping.Mapper;
import pl.kala.houseseekerdomain.domain.model.response.GetAllHousesResponse;
import pl.kala.houseseekerdomain.domain.model.response.dto.GetHouseDto;

import java.util.List;

public class GetAllHousesMapper implements Mapper<List<GetHouseDto>, GetAllHousesResponse> {
    //TODO: PAGINATION
    @Override
    public GetAllHousesResponse convert(List<GetHouseDto> source) {
        return GetAllHousesResponse.builder()
                .houses(source)
                .totalElements(source.size())
                .build();
    }

}
