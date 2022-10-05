package pl.kala.houseseekerdomain.housedomain.domain.mapping.response;


import lombok.Value;
import org.springframework.data.domain.Page;
import pl.kala.houseseekerdomain.housedomain.database.model.document.house.House;
import pl.kala.houseseekerdomain.housedomain.domain.mapping.Mapper;
import pl.kala.houseseekerdomain.housedomain.domain.model.response.GetAllHousesResponse;
import pl.kala.houseseekerdomain.housedomain.domain.model.response.dto.GetHouseDto;

import java.util.List;

public class GetAllHousesMapper implements Mapper<GetAllHousesMapper.Source, GetAllHousesResponse> {
    @Value(staticConstructor = "of")
    public static class Source {
        Page<House> pagedHouses;
        List<GetHouseDto> getHouseDtoList;
    }

    @Override
    public GetAllHousesResponse convert(Source source) {
        return GetAllHousesResponse.builder()
                .houses(source.getGetHouseDtoList())
                .totalElements(source.getPagedHouses().getTotalElements())
                .pageNumber(source.getPagedHouses().getNumber())
                .totalPages(source.getPagedHouses().getTotalPages())
                .pageSize(source.getPagedHouses().getSize())
                .build();
    }
}
