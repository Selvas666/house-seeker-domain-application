package pl.kala.houseseekerdomain.domain.mapping.request

import pl.kala.houseseekerdomain.UnitSpecificationConfiguration
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.HouseKind
import pl.kala.houseseekerdomain.database.model.document.locality.Locality
import pl.kala.houseseekerdomain.domain.model.request.dto.CreateHouseDto

import io.vavr.collection.List

class CreateHouseMapperSpec extends UnitSpecificationConfiguration {

    def mapper = new CreateHouseMapper()

    def "CreateHouseMapper mapping minimal CreateHouseDto to database House"() {
        given: "A CreateHouseDto object with only NonNull fields filled in it: locality, price, squareMeters, houseKind"
        def createHouseDto = CreateHouseDto.builder()
                .locality("Wrocław")
                .price(1000000)
                .squareMeters(70)
                .houseKind(HouseKind.APARTMENT)
                .build()
        and: "A Locality with only an id and a name"
        def locality = Locality.builder()
                .id("1")
                .name("Wrocław")
                .build()
        and: "A Source object of the two"
        def source = CreateHouseMapper.Source.of(createHouseDto, locality)
        when: "CreateHouseMapper maps this object"
        def result = mapper.convert(source)
        then: "We get a House object with only localityId, price, squareMeters, houseKind, pricePerSqMeter, entryDate"
        result.getId() == null
        result.getLocalityId() == locality.getId()
        result.getPrice() == createHouseDto.getPrice()
        result.getSquareMeters() == createHouseDto.getSquareMeters()
        result.getHouseKind() == createHouseDto.getHouseKind()
        result.getPricePerSqMeter() != null
        result.getEntryDate() != null
        result.getMediaList() == List.empty()
        result.getHouseState() == null
        result.getHeatingKind() == null
        result.getFloor() == null
        result.getElevator() == null
        result.getBuildDate() == null
        result.getHasBalcony() == null
        result.getHasBasement() == null
    }

    def "CreateHouseMapper mapping maximum CreateHouseDto to database House"() {
        given: "A CreateHouseDto object with all the fields filled in it."
        def createHouseDto = CreateHouseDto.random()
        and: "A Locality with all of its fields filled in"
        def locality = Locality.random()
        and: "A Source object of the two"
        def source = CreateHouseMapper.Source.of(createHouseDto, locality)
        when: "CreateHouseMapper maps this object"
        def result = mapper.convert(source)
        then: "We get a House object with all of the fields, properly mapped"
        result.getId() == null
        result.getLocalityId() == locality.getId()
        result.getPrice() == createHouseDto.getPrice()
        result.getSquareMeters() == createHouseDto.getSquareMeters()
        result.getHouseKind() == createHouseDto.getHouseKind()
        result.getPricePerSqMeter() != null
        result.getEntryDate() != null
        result.getMediaList() != List.empty()
        result.getHouseState() == createHouseDto.getHouseState()
        result.getHeatingKind() == createHouseDto.getHeatingKind()
        result.getFloor() == createHouseDto.getFloor()
        result.getElevator() == createHouseDto.getElevator()
        result.getBuildDate() == createHouseDto.getBuildDate()
        result.getHasBalcony() == createHouseDto.getHasBalcony()
        result.getHasBasement() == createHouseDto.getHasBasement()
    }


}
