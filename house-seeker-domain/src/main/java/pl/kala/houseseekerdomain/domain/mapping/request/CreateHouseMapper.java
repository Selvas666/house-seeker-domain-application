package pl.kala.houseseekerdomain.domain.mapping.request;

import io.vavr.collection.List;
import lombok.Value;
import pl.kala.houseseekerdomain.database.model.document.house.House;
import pl.kala.houseseekerdomain.database.model.document.locality.Locality;
import pl.kala.houseseekerdomain.domain.mapping.Mapper;
import pl.kala.houseseekerdomain.domain.model.request.dto.CreateHouseDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class CreateHouseMapper implements Mapper <CreateHouseMapper.Source, House> {

    @Value(staticConstructor = "of")
    public static class Source {
        CreateHouseDto createHouseDto;
        Locality locality;
    }

    @Override
    public House convert(CreateHouseMapper.Source source) {
        return House.builder()
                .localityId(source.getLocality().getId())
                .price(source.getCreateHouseDto().getPrice())
                .squareMeters(source.getCreateHouseDto().getSquareMeters())
                .mediaList(source.getCreateHouseDto().getMediaList().orElse(List.empty()))
                .houseKind(source.getCreateHouseDto().getHouseKind())
                .houseState(source.getCreateHouseDto().getHouseState())
                .heatingKind(source.getCreateHouseDto().getHeatingKind())
                .floor(source.getCreateHouseDto().getFloor())
                .elevator(source.getCreateHouseDto().isElevator())
                .buildDate(source.getCreateHouseDto().getBuildDate())
                .pricePerSqMeter(caluclatePricePerMeter(source.getCreateHouseDto()))
                .hasBalcony(source.getCreateHouseDto().isHasBalcony())
                .hasBasement(source.getCreateHouseDto().isHasBasement())
                .entryDate(LocalDateTime.now())
                .build();
    }

    private double caluclatePricePerMeter (CreateHouseDto createHouseDto){
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
