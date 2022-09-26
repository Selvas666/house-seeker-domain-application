package pl.kala.houseseekerdomain.domain.mapping.response

import pl.kala.houseseekerdomain.UnitSpecificationConfiguration
import pl.kala.houseseekerdomain.database.model.document.house.House
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.HouseKind
import pl.kala.houseseekerdomain.domain.model.response.dto.GetHouseDto
import pl.kala.houseseekerdomain.domain.model.response.dto.GetLocalityDto

import java.time.LocalDateTime

class GetHouseMapperSpec extends UnitSpecificationConfiguration{
    def mapper = new GetHouseMapper()

    def "GetHouseMapper mapping a source object with only @NonNull fields filled in" (){
        given:"A House object that has only @NonNull filled in: id, localityId, price, squareMeters, houseKind, pricePerSqMeter, entryDate"
        House house = House.builder()
        .id("1")
        .localityId("2")
        .price(60000)
        .squareMeters(60.55)
        .houseKind(HouseKind.APARTMENT)
        .pricePerSqMeter(5000.55)
        .entryDate(LocalDateTime.now())
        .build()
        and: "a GetLocalityDto with only the name field filled in"
        GetLocalityDto getLocalityDto = GetLocalityDto.builder()
        .name("Wrocław")
        .build()
        and:"A source object constructed of the two"
        GetHouseMapper.Source source = GetHouseMapper.Source.of(house, getLocalityDto)
        when:"The mapper maps the object"
        GetHouseDto result = mapper.convert(source)
        then:"Resulting object has only @NotNull fields filled in: id, locality, price, squareMeters, pricePerSqMeter, houseKind"
        result.getId() == house.getId()
        result.getLocality() == getLocalityDto
        result.getPrice() == house.getPrice()
        result.getSquareMeters() == house.getSquareMeters()
        result.getPricePerSqMeter() == house.getPricePerSqMeter()
        result.getHouseKind() == house.getHouseKind().getLabel()

    }
}
