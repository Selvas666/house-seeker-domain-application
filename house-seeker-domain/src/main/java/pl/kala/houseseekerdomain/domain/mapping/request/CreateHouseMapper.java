package pl.kala.houseseekerdomain.domain.mapping.request;

import io.vavr.collection.List;
import lombok.Value;
import pl.kala.houseseekerdomain.database.model.document.house.House;
import pl.kala.houseseekerdomain.database.model.document.locality.Locality;
import pl.kala.houseseekerdomain.domain.mapping.Mapper;
import pl.kala.houseseekerdomain.domain.model.request.CreateHouseRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class CreateHouseMapper implements Mapper <CreateHouseMapper.Source, House> {

    @Value(staticConstructor = "of")
    public static class Source {
        CreateHouseRequest createHouseRequest;
        Locality locality;
    }

    @Override
    public House convert(CreateHouseMapper.Source source) {
        return House.builder()
                .localityId(source.getLocality().getId())
                .price(source.getCreateHouseRequest().getPrice())
                .squareMeters(source.getCreateHouseRequest().getSquareMeters())
                .mediaList(source.getCreateHouseRequest().getMediaList() != null ? source.getCreateHouseRequest().getMediaList() : List.empty())
                .houseKind(source.getCreateHouseRequest().getHouseKind())
                .houseState(source.getCreateHouseRequest().getHouseState())
                .heatingKind(source.getCreateHouseRequest().getHeatingKind())
                .floor(source.getCreateHouseRequest().getFloor())
                .elevator(source.getCreateHouseRequest().getElevator())
                .buildDate(source.getCreateHouseRequest().getBuildDate())
                .pricePerSqMeter(calculatePricePerMeter(source.getCreateHouseRequest()))
                .hasBalcony(source.getCreateHouseRequest().getHasBalcony())
                .hasBasement(source.getCreateHouseRequest().getHasBasement())
                .entryDate(LocalDateTime.now())
                .build();
    }

    private Double calculatePricePerMeter(CreateHouseRequest createHouseDto){
        return BigDecimal.valueOf(createHouseDto.getPrice())
                .setScale(2, RoundingMode.HALF_UP)
                .divide(
                        BigDecimal.valueOf(createHouseDto.getSquareMeters())
                                .setScale(2, RoundingMode.HALF_UP),
                        RoundingMode.HALF_UP
                        )
                .doubleValue();
    }
}
