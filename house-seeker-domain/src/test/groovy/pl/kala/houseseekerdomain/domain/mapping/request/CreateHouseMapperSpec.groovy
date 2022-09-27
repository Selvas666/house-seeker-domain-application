package pl.kala.houseseekerdomain.domain.mapping.request


import pl.kala.houseseekerdomain.UnitSpecificationConfiguration
import pl.kala.houseseekerdomain.database.model.document.house.enumeration.HouseKind
import pl.kala.houseseekerdomain.database.model.document.locality.Locality
import pl.kala.houseseekerdomain.domain.model.request.CreateHouseRequest

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
        result.getLocalityId() == locality.getId()
        result.getPrice() == createHouseRequest.getPrice()
        result.getSquareMeters() == createHouseRequest.getSquareMeters()
        result.getHouseKind() == createHouseRequest.getHouseKind()
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
        result.getLocalityId() == locality.getId()
        result.getPrice() == createHouseRequest.getPrice()
        result.getSquareMeters() == createHouseRequest.getSquareMeters()
        result.getHouseKind() == createHouseRequest.getHouseKind()
        result.getPricePerSqMeter() != null
        result.getEntryDate() != null
        result.getMediaList().size() == createHouseRequest.getMediaList().length()
        result.getMediaList().get(0) == createHouseRequest.getMediaList().get(0)
        result.getHouseState() == createHouseRequest.getHouseState()
        result.getHeatingKind() == createHouseRequest.getHeatingKind()
        result.getFloor() == createHouseRequest.getFloor()
        result.getElevator() == createHouseRequest.getElevator()
        result.getBuildDate() == createHouseRequest.getBuildDate()
        result.getHasBalcony() == createHouseRequest.getHasBalcony()
        result.getHasBasement() == createHouseRequest.getHasBasement()
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
