package pl.kala.houseseekerdomain.housedomain.domain.mapping.request

import pl.kala.houseseekerdomain.UnitSpecificationConfiguration
import pl.kala.houseseekerdomain.housedomain.database.model.document.house.enumeration.HouseKind
import pl.kala.houseseekerdomain.housedomain.database.model.document.locality.Locality
import pl.kala.houseseekerdomain.housedomain.domain.model.request.CreateHouseRequest

import java.time.LocalDateTime

class CreateHouseMapperSpec extends UnitSpecificationConfiguration {

    def mapper = new CreateHouseMapper()

    def "CreateHouseMapper mapping minimal CreateHouseRequest to database House"() {
        given: "A CreateHouseRequest object with only NonNull fields filled in it: locality, price, squareMeters, houseKind"
        def createHouseRequest = CreateHouseRequest.builder()
                .locality("Wrocław")
                .price(1000000)
                .squareMeters(70)
                .houseKind(HouseKind.APARTMENT)
                .build()
        and: "A Locality with only an id and a name"
        def locality = Locality.builder()
                .id("1")
                .name("Wrocław")
                .entryDate(LocalDateTime.now())
                .build()
        and: "A Source object of the two"
        def source = CreateHouseMapper.Source.of(createHouseRequest, locality)
        when: "CreateHouseMapper maps this object"
        def result = mapper.convert(source)
        then: "We get a House object with only localityId, price, squareMeters, houseKind, pricePerSqMeter, entryDate"
        result.getId() == null
        result.getLocality() == source.getLocality()
        result.getPrice() == source.getCreateHouseRequest().getPrice()
        result.getSquareMeters() == source.getCreateHouseRequest().getSquareMeters()
        result.getHouseKind() == source.getCreateHouseRequest().getHouseKind()
        result.getPricePerSqMeter() != null
        result.getEntryDate() != null
        result.getMediaList() == null
        result.getHouseState() == null
        result.getHeatingKind() == null
        result.getFloor() == null
        result.getElevator() == null
        result.getBuildDate() == null
        result.getHasBalcony() == null
        result.getHasBasement() == null
    }

    def "CreateHouseMapper mapping maximum CreateHouseRequest to database House"() {
        given: "A CreateHouseRequest object with all the fields filled in it."
        def createHouseRequest = CreateHouseRequest.random()
        and: "A Locality with all of its fields filled in"
        def locality = Locality.random()
        and: "A Source object of the two"
        def source = CreateHouseMapper.Source.of(createHouseRequest, locality)
        when: "CreateHouseMapper maps this object"
        def result = mapper.convert(source)
        then: "We get a House object with all of the fields, properly mapped"
        result.getId() == null
        result.getLocality() == source.getLocality()
        result.getPrice() == source.getCreateHouseRequest().getPrice()
        result.getSquareMeters() == source.getCreateHouseRequest().getSquareMeters()
        result.getHouseKind() == source.getCreateHouseRequest().getHouseKind()
        result.getPricePerSqMeter() != null
        result.getEntryDate() != null
        result.getMediaList().size() == source.getCreateHouseRequest().getMediaList().length()
        result.getMediaList().get(0) == source.getCreateHouseRequest().getMediaList().get(0)
        result.getHouseState() == source.getCreateHouseRequest().getHouseState()
        result.getHeatingKind() == source.getCreateHouseRequest().getHeatingKind()
        result.getFloor() == source.getCreateHouseRequest().getFloor()
        result.getElevator() == source.getCreateHouseRequest().getElevator()
        result.getBuildDate() == source.getCreateHouseRequest().getBuildDate()
        result.getHasBalcony() == source.getCreateHouseRequest().getHasBalcony()
        result.getHasBasement() == source.getCreateHouseRequest().getHasBasement()
    }

    def "Test PricePerSqMeter calculation"() {
        given: "A CreateHouseRequest object with price = 600 000 , squareMeters = 90 "
        def createHouseRequest = CreateHouseRequest.builder()
                .locality("Wrocław")
                .price(600000)
                .squareMeters(90)
                .houseKind(HouseKind.APARTMENT)
                .build()
        and: "A Locality with only an id and a name"
        def locality = Locality.builder()
                .id("1")
                .name("Wrocław")
                .entryDate(LocalDateTime.now())
                .build()
        and: "A Source object of the two"
        def source = CreateHouseMapper.Source.of(createHouseRequest, locality)
        when: "CreateHouseMapper maps this object"
        def result = mapper.convert(source)
        then: "We get a House object with PricePerSqMeter = 6 666,67"
        result.getPricePerSqMeter() == 6666.67
    }


}
