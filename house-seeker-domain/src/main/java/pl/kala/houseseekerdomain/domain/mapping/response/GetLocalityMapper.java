package pl.kala.houseseekerdomain.domain.mapping.response;

import pl.kala.houseseekerdomain.database.model.document.locality.Locality;
import pl.kala.houseseekerdomain.domain.mapping.Mapper;
import pl.kala.houseseekerdomain.domain.mapping.utils.MapperUtils;
import pl.kala.houseseekerdomain.domain.model.response.dto.GetLocalityDto;

public class GetLocalityMapper implements Mapper<Locality, GetLocalityDto> {
    @Override
    public GetLocalityDto convert(Locality locality) {
        return GetLocalityDto.builder()
                .name(locality.getName())
                .voivodeship(locality.getVoivodship() == null ? MapperUtils.emptyString() : locality.getVoivodship().getLabel())
                .distanceFromHome(locality.getDistanceFromHome())
                .distanceFromRailStation(locality.getDistanceFromRailStation())
                .build();
    }
}
