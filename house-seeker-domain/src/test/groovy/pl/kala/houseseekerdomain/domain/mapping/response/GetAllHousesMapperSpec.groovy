package pl.kala.houseseekerdomain.domain.mapping.response

import io.vavr.collection.List
import pl.kala.houseseekerdomain.UnitSpecificationConfiguration
import pl.kala.houseseekerdomain.domain.model.response.GetAllHousesResponse
import pl.kala.houseseekerdomain.domain.model.response.dto.GetHouseDto

class GetAllHousesMapperSpec extends UnitSpecificationConfiguration {

    GetAllHousesMapper mapper = new GetAllHousesMapper()

    def "Test GetAllHousesMapper mapping an empty list"() {
        given: "an empty GetHouseDto list"
        List<GetHouseDto> houseList = List.empty()
        when: "the mapper maps the empty list"
        GetAllHousesResponse result = mapper.convert(houseList)
        then: "the list in resulting GetAllHousesResponse is empty and totalElements == 0"
        result.getHouses() == List.empty()
        result.getTotalElements() == 0
    }

    def "Test GetAllHousesMapper mapping a non-empty list"() {
        given: "A GetHouseDto list with more than 0 elements"
        List<GetHouseDto> houseList = GetHouseDto.randomList(3)
        when: "the mapper maps the list"
        GetAllHousesResponse result = mapper.convert(houseList)
        then: "the list in resulting GetAllHousesResponse is not empty and has the totalElements == source list length"
        result.getHouses() != List.empty()
        result.getTotalElements() == houseList.length()
    }

}
