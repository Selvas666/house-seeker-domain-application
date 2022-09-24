package pl.kala.houseseekerdomain.domain.mapping;

import pl.kala.houseseekerdomain.database.model.document.locality.Locality;
import pl.kala.houseseekerdomain.domain.model.dto.LocalityDto;

public class LocalityMapper implements Mapper <Locality, LocalityDto>{
    @Override
    public LocalityDto convert(Locality locality) {
        return LocalityDto.builder()
                .name(locality.getName())
                .voivodeship(locality.getVoivodship().getLabel())
                .distanceFromHome(locality.getDistanceFromHome())
                .distanceFromRailStation(locality.getDistanceFromRailStation())
                .build();
    }
}
