package pl.kala.houseseekerdomain.domain.mapping;

import io.vavr.collection.List;
import pl.kala.houseseekerdomain.domain.model.GetAllHousesResponse;
import pl.kala.houseseekerdomain.domain.model.dto.HouseDto;

public class GetAllHousesMapper implements Mapper <List<HouseDto>, GetAllHousesResponse>{
//TODO: PAGINATION
    @Override
    public GetAllHousesResponse convert(List<HouseDto> source) {
        return GetAllHousesResponse.builder()
                .houses(source)
                .totalElements(source.length())
                .build();
    }

}
