package pl.kala.houseseekerdomain.domain.mapping.response;

import lombok.Value;
import pl.kala.houseseekerdomain.database.model.document.house.House;
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.Media;
import pl.kala.houseseekerdomain.domain.mapping.Mapper;
import pl.kala.houseseekerdomain.domain.model.response.dto.GetHouseDto;
import pl.kala.houseseekerdomain.domain.model.response.dto.GetLocalityDto;

import java.util.stream.Collectors;

public class GetHouseMapper implements Mapper<GetHouseMapper.Source, GetHouseDto> {

    @Value(staticConstructor = "of")
    public static class Source {
        House house;
        GetLocalityDto locality;
    }

    @Override
    public GetHouseDto convert(GetHouseMapper.Source source) {
        return GetHouseDto.builder()
                .id(source.getHouse().getId())
                .locality(source.getLocality())
                .price(source.getHouse().getPrice())
                .squareMeters(source.getHouse().getSquareMeters())
                .houseKind(source.getHouse().getHouseKind().getLabel())
                .mediaList(source.getHouse().getMediaList() == null ? null : source.getHouse().getMediaList().stream().map(Media::getLabel).collect(Collectors.toList()))
                .houseState(source.getHouse().getHouseState() == null ? null : source.getHouse().getHouseState().getLabel())
                .heatingKind(source.getHouse().getHeatingKind() == null ? null : source.getHouse().getHeatingKind().getLabel())
                .floor(source.getHouse().getFloor())
                .elevator(source.getHouse().getElevator())
                .buildDate(source.getHouse().getBuildDate())
                .pricePerSqMeter(source.getHouse().getPricePerSqMeter())
                .hasBalcony(source.getHouse().getHasBalcony())
                .hasBasement(source.getHouse().getHasBasement())
                .build();
    }
}
