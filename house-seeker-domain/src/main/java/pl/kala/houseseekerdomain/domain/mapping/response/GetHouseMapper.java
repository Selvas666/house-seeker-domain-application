package pl.kala.houseseekerdomain.domain.mapping.response;

import io.vavr.collection.List;
import lombok.Value;
import pl.kala.houseseekerdomain.database.model.document.house.House;
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.Media;
import pl.kala.houseseekerdomain.domain.mapping.Mapper;
import pl.kala.houseseekerdomain.domain.mapping.utils.MapperUtils;
import pl.kala.houseseekerdomain.domain.model.response.dto.GetHouseDto;
import pl.kala.houseseekerdomain.domain.model.response.dto.GetLocalityDto;

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
                .mediaList(source.getHouse().getMediaList() == null ? List.empty() : List.ofAll(source.getHouse().getMediaList().map(Media::getLabel)))
                .houseState(source.getHouse().getHouseState() == null ? MapperUtils.emptyString() : source.getHouse().getHouseState().getLabel())
                .heatingKind(source.getHouse().getHeatingKind() == null ? MapperUtils.emptyString() : source.getHouse().getHeatingKind().getLabel())
                .floor(source.getHouse().getFloor())
                .elevator(source.getHouse().getElevator())
                .buildDate(source.getHouse().getBuildDate())
                .pricePerSqMeter(source.getHouse().getPricePerSqMeter())
                .hasBalcony(source.getHouse().getHasBalcony())
                .hasBasement(source.getHouse().getHasBasement())
                .build();
    }
}
