package pl.kala.houseseekerdomain.domain.mapping;

import lombok.Value;
import pl.kala.houseseekerdomain.database.model.document.house.House;
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.Media;
import pl.kala.houseseekerdomain.domain.model.dto.HouseDto;
import pl.kala.houseseekerdomain.domain.model.dto.LocalityDto;

public class HouseMapper implements Mapper <HouseMapper.Source, HouseDto> {

    @Value(staticConstructor = "of")
    public static class Source {
        House house;
        LocalityDto locality;
    }

    @Override
    public HouseDto convert(HouseMapper.Source source) {
        return HouseDto.builder()
                .id(source.getHouse().getId())
                .locality(source.getLocality())
                .price(source.getHouse().getPrice())
                .squareMeters(source.getHouse().getSquareMeters())
                .mediaList(source.getHouse().getMediaList().map(Media::getLabel).toList())
                .houseKind(source.getHouse().getHouseKind().getLabel())
                .heatingKind(source.getHouse().getHeatingKind().getLabel())
                .floor(source.getHouse().getFloor())
                .elevator(source.getHouse().isElevator())
                .buildDate(source.getHouse().getBuildDate())
                .pricePerSqMeter(source.getHouse().getPricePerSqMeter())
                .hasBalcony(source.getHouse().isHasBalcony())
                .hasBasement(source.getHouse().isHasBasement())
                .build();
    }
}
