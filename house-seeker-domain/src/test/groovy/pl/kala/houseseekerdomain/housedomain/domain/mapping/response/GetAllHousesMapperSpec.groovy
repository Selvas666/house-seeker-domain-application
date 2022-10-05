package pl.kala.houseseekerdomain.housedomain.domain.mapping.response

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import pl.kala.houseseekerdomain.UnitSpecificationConfiguration
import pl.kala.houseseekerdomain.housedomain.database.model.document.house.House
import pl.kala.houseseekerdomain.housedomain.domain.model.response.GetAllHousesResponse
import pl.kala.houseseekerdomain.housedomain.domain.model.response.dto.GetHouseDto

class GetAllHousesMapperSpec extends UnitSpecificationConfiguration {

    GetAllHousesMapper mapper = new GetAllHousesMapper()

    def "Test GetAllHousesMapper mapping an empty list"() {
        given: "an empty GetHouseDto list and an empty page object"
        Page<House> pagedHouse = Page<House>.empty()
        List<GetHouseDto> houseList = Collections.emptyList()
        when: "the mapper maps the empty list"
        GetAllHousesResponse result = mapper.convert(GetAllHousesMapper.Source.of(pagedHouse, houseList))
        then: "the list in resulting GetAllHousesResponse is empty and totalElements == 0"
        result.getHouses() == Collections.emptyList()
        result.getTotalElements() == 0
        result.getPageNumber() == 0
        result.getPageSize() == 0
        result.getTotalPages() == 1
    }

    def "Test GetAllHousesMapper mapping a non-empty list and page"() {
        given: "A GetHouseDto list with more than 0 elements and a non empty Page object"
        int totalElements = 3
        Page<House> pagedHouse = new PageImpl<>(House.randomList(totalElements))
        List<GetHouseDto> houseList = GetHouseDto.randomList(totalElements)
        when: "the mapper maps the list"
        GetAllHousesResponse result = mapper.convert(GetAllHousesMapper.Source.of(pagedHouse, houseList))
        then: "the list in resulting GetAllHousesResponse is not empty and has the totalElements == number of totalElements"
        result.getHouses() != Collections.emptyList()
        result.getHouses().size() == pagedHouse.getTotalElements()
        result.getTotalElements() == pagedHouse.getTotalElements()
        result.getTotalPages() == pagedHouse.getTotalPages()
        result.getPageSize() == pagedHouse.getSize()
        result.getPageNumber() == 0
    }

}
